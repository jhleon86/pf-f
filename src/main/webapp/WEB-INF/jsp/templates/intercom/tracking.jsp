<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
	<head>
		<style>
			/* Always set the map height explicitly to define the size of the div
			* element that contains the map. */
			#map {
				height: 80%;
			}
			/* Optional: Makes the sample page fill the window. */
			html, body {
				height: 100%;
				margin: 0;
				padding: 0;
			}
		</style>   
	</head>
	<body>
		<h3 id="id">Intercom ID : ${ID}</h3> 
		<h3 id="loca"></h3>
		<h3 id="lastupdate">${lastUpdate}</h3>
		<div id="map"></div>
	</body>

  	<script>
  	 
  	var main = {
  		init : function() {
  			var _this = this;	 
  			_this.showPosition(); 
  		},
  		showPosition : function() {
  			var _this = this;
  			
  		  	var g_lat;
  		  	var g_lng;
  		  	var g_loctext; 
  			
  			g_lat = ${lat};
  			g_lng = ${lng};
  			
  			$.get("https://maps.googleapis.com/maps/api/geocode/json",
  					{latlng : g_lat+","+g_lng
  					,language : "en"  
  					,key : "AIzaSyDrnR0X6g5hpsScXyp71r7R9IfeB2CWgE0"}
  			).done(function(data){ 
  				g_loctext = data.results[0].formatted_address;
  				//alert(g_loctext);
  				$("#loca").text(g_loctext);
				
  				//----draw map
  				var latlng = {lat: g_lat, lng: g_lng};
  	  		  	var map = new google.maps.Map(
  	  		  		document.getElementById('map')
  	  		    	, {zoom: 17, center: latlng}
  	  		    );
  	  		  	
  	  		  	var marker = new google.maps.Marker({position: latlng, map: map});
  	  		  	
  	  			//----intercom visitor location update
  				var param = new Object;
  	  			
  	  			param.lat = g_lat;
  	  			param.lng = g_lng;
  	  			param.loc = g_loctext; 
  	  			param.vsid = localStorage.getItem("vsid");
  	  			 
  	  			$.post("/intercom/update",param);
  			}); 
  		},
  	} 
    </script>
    <script src="/static/js/lib/jquery.min.js"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDrnR0X6g5hpsScXyp71r7R9IfeB2CWgE0&callback=main.init"></script>
</html>


