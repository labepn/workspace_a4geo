import { Component, OnInit } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Map, View} from 'ol';
import TileLayer from 'ol/layer/Tile';
import VectorLayer from 'ol/layer/Vector';
import XYZ from 'ol/source/XYZ';
import OSM from 'ol/source/OSM.js';
import {fromLonLat} from 'ol/proj.js';

import TileWMS from 'ol/source/TileWMS.js';
import GeoJSON from 'ol/format/GeoJSON.js';
import VectorSource from 'ol/source/Vector.js';
import {Stroke, Text, Style, Fill} from 'ol/style.js';
import Select from 'ol/interaction/Select.js';
import {bbox as bboxStrategy} from 'ol/loadingstrategy.js';
import {InfoComponent } from './info/info.component'; 
import {MatDialog, MatDialogConfig, MatDialogRef} from '@angular/material'; 

import Feature from 'ol/Feature.js';
import Point from 'ol/geom/Point.js';
import {Icon} from 'ol/style.js';

import {click, pointerMove} from 'ol/events/condition';

import { GeoportalService } from './geoportal.service'; 


import Circle from 'ol/geom/Circle.js';
import Polygon from 'ol/geom/Polygon.js';


import {addProjection, addCoordinateTransforms, transform} from 'ol/proj.js';
import Projection from 'ol/proj/Projection.js';

import {register} from 'ol/proj/proj4.js';

import proj4 from 'proj4';

import {get as getProjection} from 'ol/proj.js';

export interface WMSLejeri {
    type: string;
    title:string;
    name: string;
    position: number;
    url: string;
    visible: boolean;
  }

  const ELEMENT_DATA: WMSLejeri[] = [
    {type: 'WMS', title: 'Parcele', position: 1, name: 'cite:parcele_ns_32634', url: 'http://localhost:8080/geoserver/wms', visible: false},
    {type: 'WMS', title: 'Objekti', position: 2, name: 'cite:objekti_ns_32634', url: 'http://localhost:8080/geoserver/wms', visible: false},
    {type: 'WMS', title: 'Tereni', position: 3, name: 'cite:tereni', url: 'http://localhost:8080/geoserver/wms', visible: false},
   
  ];
  


@Component({
  selector: 'app-geoportal',
  templateUrl: './geoportal.component.html',
  styleUrls: ['./geoportal.component.css']
})
export class GeoportalComponent implements OnInit {
    
    map;
    view;
    dataSource = ELEMENT_DATA;
    crs='EPSG:32634';
    
    geojson;
    geojson1;
    
    select;

  constructor(private geoportalService: GeoportalService, private dialog: MatDialog) { }
  

  ngOnInit() {
      this.initMap();
  }
  
  getGeoJson(){
      this.geoportalService.getGeoJson().subscribe(result => { this.geojson = result; this.afterInit(); });
  }
  
  initMap(){           
      
      
     this.getGeoJson();
     // this.getGeoJson1();
      //https://spatialreference.org/ref/epsg/32634/
      //https://epsg.io/32634
      
      proj4.defs('EPSG:32634', '+proj=utm +zone=34 +ellps=WGS84 +datum=WGS84 +units=m +no_defs');
      register(proj4);

      var proj32634 = getProjection('EPSG:32634');
      proj32634.setExtent([166021.44, 0.00, 534994.66, 9329005.18]);
      
     
      
      var raster = new TileLayer({
          source: new OSM()
      }); 
      
      var layers=[];
      layers.push(raster);
      
      
      var vectorSource;
      
      for (let entry of this.dataSource) {
          console.log(entry.name + entry.url);
          if (entry.type=='WMS') {
              var sloj= new TileLayer({                  
                  source: new TileWMS({                    
                    url: entry.url,
                    params: {'LAYERS': entry.name, 'TILED': true},
                    serverType: 'geoserver',                    
                    transition: 0
                  }),
                  visible : entry.visible
                });
              
              layers.push(sloj);
          } else {
              var vcrs=this.crs;
              vectorSource = new VectorSource({
                  format: new GeoJSON(),
                  url: function(extent) {
                      return entry.url+'?service=WFS&' +
                      'version=1.1.0&request=GetFeature&typename=' + entry.name + '&'+
                      'outputFormat=application/json&srsname='+vcrs+'&' +
                      'bbox=' + extent.join(',') + ','+vcrs;
                  },
                  strategy: bboxStrategy
                });
              var style = new Style({
                  stroke: new Stroke({
                      color: '#000',
                      width: 1
                  }),
                  text: new Text({
                      font: '12px Calibri,sans-serif',            
                      stroke: new Stroke({
                        color: '#fff', width: 2
                      }),
                      // get the text from the feature - `this` is ol.Feature
                      // and show only under certain resolution
                      text: 'Pera'
                  })
              });
              
              var vector = new VectorLayer({
                source: vectorSource,
                visible : true,
                style: function(feature) {                    
                    style.getText().setText(feature.get('brparcele'));
                    return style;
                }        
              });
            layers.push(vector);  
             
              
          }
         
          
      }
      
      
      
      
      
       //N: 4950391 E: 306435
      /*
       * 
       * 
      var projection = new Projection({
          code: 'EPSG:32634',
          // The extent is used to determine zoom level 0. Recommended values for a
          // projection's validity extent can be found at https://epsg.io/.
          extent: [7423922.007,5054790.257, 7409764,5011669],
          units: 'm'
        });
        addProjection(projection);*/
        
       // var extent = [420000, 30000, 900000, 350000];
      this.view =new View({
          projection: proj32634,    //'EPSG:3857'
          //center: transform([19.833549, 45.267136], 'EPSG:4326', 'EPSG:32634'), //bar 19.10028, 42.09306 ns 19.833549, 45.267136  //3857 //center: fromLonLat([20.03331, 45.61632],'EPSG:32634')
          center: [ 408957, 5011224],           
          zoom: 14              
          //zoom: 4
      });
      
      this.map=new Map({
          target: 'map',
          layers:layers,
          view: this.view
        });
      
      

  }
  
  afterInit(){
     
      var vectorSourceGJ = new  VectorSource();
      var vectorSourceGJ1 = new  VectorSource();
      
      if (this.geojson !== undefined && this.geojson.length>0) {
          for (let gj of this.geojson) {
              vectorSourceGJ.addFeature(new Feature(new Polygon( gj.geometrija.coordinates)));
          }
      }
      
      if (this.geojson1 !== undefined && this.geojson1.length>0) {
          for (let gj of this.geojson1) {
              vectorSourceGJ1.addFeature(new Feature(new Polygon( gj.geometrija.coordinates)));
          }
      }
      
      var styleGJ = new Style({
          stroke: new Stroke({
              color: '#000000',
              width: 1
          }),
          fill: new Fill({
              color: '#00000033'
          }),
          text: new Text({
              font: '12px Calibri,sans-serif',            
              stroke: new Stroke({
                color: '#fff', width: 2
              }),
              // get the text from the feature - `this` is ol.Feature
              // and show only under certain resolution
              text: ""
          })
      });
      
      var styleGJ1 = new Style({
          stroke: new Stroke({
              color: '#ff0000',
              width: 1
          }),
          fill: new Fill({
              color: '#ff00003D'
          }),
          text: new Text({
              font: '12px Calibri,sans-serif',            
              stroke: new Stroke({
                color: '#fff', width: 2
              }),
              // get the text from the feature - `this` is ol.Feature
              // and show only under certain resolution
              text: ""
          })
      });
      
      var vectorGJ = new VectorLayer({
          source: vectorSourceGJ,
          visible : false,
          style: styleGJ       
        });
      
      var vectorGJ1 = new VectorLayer({
          source: vectorSourceGJ1,
          visible : false,
          style: styleGJ1       
        });
      console.log(this.map.getLayers().getArray());
      this.map.addLayer(vectorGJ);
      this.map.addLayer(vectorGJ1);
      

     this.select = new Select();
     
     
     
      var map = this.map;
      var view = this.view
      var crsc = this.crs;
        
      //this.changeInteraction();   
    


        
        var dlg=this.dialog; 
        
        map.on('click', function(evt) {
            var viewResolution = /** @type {number} */ (view.getResolution()); 
                if(map.getLayers().getArray()[1].getVisible() == true && map.getLayers().getArray()[2].getVisible() == false && map.getLayers().getArray()[3].getVisible() == false){
                    var src1 = map.getLayers().getArray()[1].getSource();
                var urlParc = src1.getGetFeatureInfoUrl( evt.coordinate, viewResolution, crsc, {'INFO_FORMAT': 'application/json'}); 
                fetch(urlParc).then(response => {  //poziv getFeatureInfo zahteva prema geoserveru na datim koordinatama                    
                  return response.json();
              }).then(data => { //kada dobije podatke o parceli sa geoservera otvara info dijalog
                    // Work with JSON data here        
                    var parcelData=data.features[0].properties;   
                    console.log(parcelData.TEXTSTRING);
                    
                    //otvaranje dijaloga
                    const dialogConfigLayers = new MatDialogConfig();
                    dialogConfigLayers.disableClose = true;
                    dialogConfigLayers.autoFocus = true;
                    dialogConfigLayers.data = {      //prenos parametara u komponentu Info                      
                            title: 'Podaci za parcelu',
                            brParc: parcelData.TEXTSTRING,       //ovo je atribut u sloju parcela koji sadrzi broj parcele                     
                            parcelData : [parcelData],           //ovo su svi podaci o parceli koji stizu sa servera      
                    };
                    const dialogRefLayers = dlg.open(InfoComponent, dialogConfigLayers);    
                    dialogRefLayers.afterClosed().subscribe(resultLayer => {
                        console.log('ZATVORIO ' );                                    
                    }); 
    
               }).catch(err => {
                console.log(err);
                
                });
            }else if(map.getLayers().getArray()[2].getVisible() == true && map.getLayers().getArray()[1].getVisible() == false && map.getLayers().getArray()[3].getVisible() == false){
                var src = map.getLayers().getArray()[2].getSource(); //promenom broja na 2 dobijate podatke o objektima
                var urlObj = src.getGetFeatureInfoUrl( evt.coordinate, viewResolution, crsc, {'INFO_FORMAT': 'application/json'});  
                console.log(urlObj);
                fetch(urlObj).then(response => {  //poziv getFeatureInfo zahteva prema geoserveru na datim koordinatama                    
                  return response.json();
              }).then(data => { //kada dobije podatke o parceli sa geoservera otvara info dijalog
                    // Work with JSON data here        
                    var objektiData=data.features[0].properties;   
                    console.log(objektiData.TEXTSTRING);
                    
                    //otvaranje dijaloga
                    const dialogConfigLayers = new MatDialogConfig();
                    dialogConfigLayers.disableClose = true;
                    dialogConfigLayers.autoFocus = true;
                    dialogConfigLayers.data = {      //prenos parametara u komponentu Info                      
                            title: 'Podaci za objekat',
                            brParc: objektiData.TEXTSTRING,       //ovo je atribut u sloju parcela koji sadrzi broj parcele                     
                            objektiData : [objektiData],           //ovo su svi podaci o parceli koji stizu sa servera      
                    };
                    const dialogRefLayers = dlg.open(InfoComponent, dialogConfigLayers);    
                    dialogRefLayers.afterClosed().subscribe(resultLayer => {
                        console.log('ZATVORIO ' );                                    
                    }); 
    
               }).catch(err => {
                console.log(err);
                
                });
                }else if(map.getLayers().getArray()[3].getVisible() == true && map.getLayers().getArray()[1].getVisible() == false && map.getLayers().getArray()[2].getVisible() == false){
                    var src = map.getLayers().getArray()[3].getSource(); //promenom broja na 2 dobijate podatke o objektima
                    var urlObj = src.getGetFeatureInfoUrl( evt.coordinate, viewResolution, crsc, {'INFO_FORMAT': 'application/json'});  
                    console.log(urlObj);
                    fetch(urlObj).then(response => {  //poziv getFeatureInfo zahteva prema geoserveru na datim koordinatama                    
                      return response.json();
                  }).then(data => { //kada dobije podatke o parceli sa geoservera otvara info dijalog
                        // Work with JSON data here        
                        var trgoviData=data.features[0].properties;   
                        console.log(trgoviData.TEXTSTRING);
                        
                        //otvaranje dijaloga
                        const dialogConfigLayers = new MatDialogConfig();
                        dialogConfigLayers.disableClose = true;
                        dialogConfigLayers.autoFocus = true;
                        dialogConfigLayers.data = {      //prenos parametara u komponentu Info                      
                                title: 'Podaci za terene',
                                nazTrga: trgoviData.TEXTSTRING,       //ovo je atribut u sloju parcela koji sadrzi broj parcele         
                                trgArea: trgoviData.AREA,
                                trgoviData : [trgoviData],           //ovo su svi podaci o parceli koji stizu sa servera      
                        };
                        const dialogRefLayers = dlg.open(InfoComponent, dialogConfigLayers);    
                        dialogRefLayers.afterClosed().subscribe(resultLayer => {
                            console.log('ZATVORIO ' );                                    
                        }); 
        
                   }).catch(err => {
                    console.log(err);
                    
                    });
            
        }});
        

  }

  
  check()
  {
    console.log(this.dataSource[0]);
    //var ar = [];
    //console.log(ar);
    console.log(this.map.getLayers().getArray()[1].getVisible());
    //console.log(ar[1]);
    if(this.map.getLayers().getArray()[1].getVisible() == false){
        this.map.getLayers().getArray()[1].setVisible(true);
        //ar.setVisible(false);
        //this.map.getLayers().setArray(1) = ar;
        //this.dataSource[0].visible = true;
        console.log("podeseno na true");
    }else{
        this.map.getLayers().getArray()[1].setVisible(false);
        //ar.setVisible(true);
        //this.map.getLayers().setArray(1) = ar;
        //this.dataSource[0].visible = false;
        console.log("podeseno na false");
    }
  }
  
  check1()
  {
    console.log(this.map.getLayers().getArray()[2].getVisible());
    if(this.map.getLayers().getArray()[2].getVisible() == false){
        this.map.getLayers().getArray()[2].setVisible(true);
        console.log("podeseno na true");
    }else{
        this.map.getLayers().getArray()[2].setVisible(false);
        console.log("podeseno na false");
    }
  }
  
  check2()
  {
    console.log(this.map.getLayers().getArray()[3].getVisible());
    console.log(this.map.getLayers().getArray());
    if(this.map.getLayers().getArray()[3].getVisible() == false){
        this.map.getLayers().getArray()[3].setVisible(true);
        console.log("podeseno na true");
    }else{
        this.map.getLayers().getArray()[3].setVisible(false);
        console.log("podeseno na false");
    }
  }
check3()
  {
    console.log(this.map.getLayers().getArray()[4].getVisible());
    console.log(this.map.getLayers().getArray());
    if(this.map.getLayers().getArray()[4].getVisible() == false){
        this.map.getLayers().getArray()[4].setVisible(true);
        console.log("podeseno na true");
    }else{
        this.map.getLayers().getArray()[4].setVisible(false);
        console.log("podeseno na false");
    }
  }


  //transform([19.833549, 45.267136],'EPSG:4326','EPSG:3857' ),
  //import {transform} from 'ol/proj.js';
  


}
