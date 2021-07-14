import { Component, OnInit } from '@angular/core';
import { Map, View } from 'ol';
import TileLayer from 'ol/layer/Tile';
import VectorLayer from 'ol/layer/Vector';
import XYZ from 'ol/source/XYZ';
import OSM from 'ol/source/OSM.js';
import {fromLonLat} from 'ol/proj.js';

import TileWMS from 'ol/source/TileWMS.js';
import GeoJSON from 'ol/format/GeoJSON.js';
import VectorSource from 'ol/source/Vector.js';
import {Stroke, Text, Style} from 'ol/style.js';
import Select from 'ol/interaction/Select.js';
import {bbox as bboxStrategy} from 'ol/loadingstrategy.js';

import Feature from 'ol/Feature.js';
import Point from 'ol/geom/Point.js';
import {Icon} from 'ol/style.js';

import {GeoportalmkService } from './geoportalmk.service';


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
    {type: 'WMS', title: 'Parcele', position: 1, name: 'cite:UTM_BAR_Parcele', url: 'http://147.91.175.146:8080/geoserver/ows', visible: true},
    {type: 'WMS', title: 'Objekti', position: 2, name: 'cite:UTM_BAR_Objekti', url: 'http://147.91.175.146:8080/geoserver/ows', visible: false},
    {type: 'WFS', title: 'Parcele WFS', position: 3, name: 'cite:UTM_BAR_Parcele', url: 'http://147.91.175.146:8080/geoserver/ows', visible: true},
  ];
  


@Component({
  selector: 'app-geoportalmk',
  templateUrl: './geoportalmk.component.html',
  styleUrls: ['./geoportalmk.component.css']
})
export class GeoportalmkComponent implements OnInit {
    
    map;
    dataSource = ELEMENT_DATA;
    crs='EPSG:3857';
    
    geojson;

  constructor(private geoportalService: GeoportalmkService) { }

  ngOnInit() {
      this.initMap();
  }
  
  initMap(){           
      
      this.getGeoJson();
      this.getRPJ();

      
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
                  //extent: [-13884991, 2870341, -7455066, 6338219],
                  source: new TileWMS({
                    url: entry.url,
                    params: {'LAYERS': entry.name, 'TILED': true},
                    serverType: 'geoserver',
                    // Countries have transparency, so do not fade tiles:
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
                      color: '#aaa',
                      width: 0.1
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
                    //console.log('Check you get the property', feature.get('Broj_parce'));
                    style.getText().setText(feature.get('Broj_parce'));
                    return style;
                }        
              });
            layers.push(vector);  
             
              
          }
         
          
      }
      
      //https://spatialreference.org/ref/epsg/32634/
      
      proj4.defs('EPSG:32634', '+proj=utm +zone=34 +ellps=WGS84 +datum=WGS84 +units=m +no_defs');
      register(proj4);

      var proj32634 = getProjection('EPSG:32634');
      proj32634.setExtent([166021.44, 0.00, 534994.66, 9329005.18]);
      
      
      
       //N: 4950391 E: 306435
      /*
       * https://epsg.io/32634
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
      
      this.map=new Map({
          target: 'map',
          layers:[raster],
          view: new View({
              projection: proj32634,    
              //center: transform([20.0333, 45.61632], 'EPSG:4326', 'EPSG:32634'), //bar 19.10028, 42.09306 ns 19.833549, 45.267136  //3857 //center: fromLonLat([20.03331, 45.61632],'EPSG:32634')
              center: [ 423922.007, 5054790.257],
              zoom: 14
              //center: [-10997148, 4569099],
              //zoom: 4
          })
        });
      
      
  }
  
  //transform([19.833549, 45.267136],'EPSG:4326','EPSG:3857' ),
  //import {transform} from 'ol/proj.js';
  
  getGeoJson(){
      this.geoportalService.getGeoJson().subscribe(result => { this.geojson = result; this.afterInit(); });
  }
  
  getRPJ(){
      this.geoportalService.getRPJ().subscribe(result => { this.geojson = result; this.afterInit(); });
  }
  
  afterInit(){
      
      
      
      
      console.log(JSON.stringify(this.geojson[0].geometrija.coordinates));
      
      var poligon=this.geojson[0].geometrija.coordinates;
      
      var ring = [[[423922.007,5054790.257],[423921.067,5054777.561],[423910.51,5054778.461],[423905.931,5054778.851],[423903.222,5054779.081],[423882.817,5054780.821],[423884.077,5054793.577],[423922.007,5054790.257]]];
      var nessto=new Polygon([ring]);
      
      
      
      var vectorSourceGJ = new  VectorSource();
      
      if (this.geojson !== undefined && this.geojson.length>0) {
          for (let gj of this.geojson) {
              vectorSourceGJ.addFeature(new Feature(new Polygon( gj.geometrija.coordinates)  ));
          }
      }
      
      //vectorSourceGJ.addFeature(new Feature(new Polygon( this.geojson[0].geometrija.coordinates)  ));
      
    /*  var vectorSourceGJ = new VectorSource({
          features: (new GeoJSON()).readFeatures(pera)
        });*/
      
      /*var vectorSourceGJ = new VectorSource({
          features: new Feature(new Polygon(this.geojson[0].geometrija.coordinates))
        });*/
      
      var styleGJ = new Style({
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
              text: '1/1'
          })
      });
      
      var vectorGJ = new VectorLayer({
          source: vectorSourceGJ,
          visible : true,
          style: styleGJ       
        });
      
      this.map.addLayer(vectorGJ);
      
     
  }
  
  //147.91.175.146

  //administrator
  //eTerra01Ora146

}
