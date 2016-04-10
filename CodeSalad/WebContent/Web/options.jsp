
   <script type="text/javascript">
   var nameElement=1;
     function addText(name) {
    	
     var element = document.createElement("textarea");
   
     var text = document.getElementById("testCases");
   

     element.setAttribute("name", nameElement);
     nameElement++;
     element.setAttribute("cols",1);
     element.setAttribute("rows",2);

    text.appendChild(element);
    text.innerHTML = text.innerHTML+"testcase";
    
    		 
    var element1 = document.createElement("textarea");
    
    var text1 = document.getElementById("testCases");
  

    element1.setAttribute("name", nameElement);
    nameElement++;
    element1.setAttribute("cols",1);
    element1.setAttribute("rows",2);

   text1.appendChild(element1);
   text1.innerHTML = text1.innerHTML+" value <br/>"  ;
   		 
    
    

}


    </script>

   
    <input type="button" value="Text Area" onclick="addText('textarea')">
       
    <div id="testCases"> </div>
    
    
    
    