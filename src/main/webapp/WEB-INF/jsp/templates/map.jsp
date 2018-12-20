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
        height: 100%;
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
    <h3>My Google Maps Demo</h3>
    <!--The div element for the map -->
    <div id="map"></div>

    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script src="static_tmp/vendor/jquery/jquery.min.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDrnR0X6g5hpsScXyp71r7R9IfeB2CWgE0&callback=getLocation">
    </script>
    
        <script>
    var g_lat;
    var g_lng;
    var faddr;
    var vid = localStorage.getItem("vid");
// Initialize and add the map
function initMap() {
  // The location of Uluru
   var uluru = {lat: g_lat, lng: g_lng};
  
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 17, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
  
}


function showPosition(position) {
	
	g_lat = position.coords.latitude;
	g_lng = position.coords.longitude;
	
	$.get("https://maps.googleapis.com/maps/api/geocode/json",
			{latlng : position.coords.latitude+","+position.coords.longitude
			,language : "en"  
			,key : "AIzaSyDrnR0X6g5hpsScXyp71r7R9IfeB2CWgE0"}
	).done(function(data){ 
		faddr = data.results[0].formatted_address;
		alert(faddr);
		
		//setIntercom(data.results[0].formatted_address, g_lat, g_lng);
		 initMap();
	}); 
}


function getLocation() {
    if (navigator.geolocation) { 
        var geo = navigator.geolocation.getCurrentPosition(showPosition); 
       
    } else { 
    	alert("Geolocation is not supported by this browser.");
    	
    }
}

function updateLocation(){
	
	$.ajax({
		  url: "/intercom/update/"+vid,
		  data: {
		    zipcode: 97201
		  },
		  success: function( result ) {
		    $( "#weather-temp" ).html( "<strong>" + result + "</strong> degrees" );
		  }
		});
	
}


    </script>
    <script>(function(){var w=window;var ic=w.Intercom;if(typeof ic==="function"){ic('reattach_activator');ic('update',intercomSettings);}else{var d=document;var i=function(){i.c(arguments)};i.q=[];i.c=function(args){i.q.push(args)};w.Intercom=i;function l(){var s=d.createElement('script');s.type='text/javascript';s.async=true;s.src='https://widget.intercom.io/widget/fx8n9i8g';var x=d.getElementsByTagName('script')[0];x.parentNode.insertBefore(s,x);}if(w.attachEvent){w.attachEvent('onload',l);}else{w.addEventListener('load',l,false);}}})()</script>
	  
  </body>
</html>


