
   <script type="text/javascript">
   var nameElement=1;
     function addText(name) {
    	 for(var i=0;i<2;i++)
    		 {
     var element = document.createElement("textarea");
   
     var text = document.getElementById("testCases");
   

     element.setAttribute("name", nameElement);
     nameElement++;
     element.setAttribute("cols",1);
     element.setAttribute("rows",2);

    text.appendChild(element);
    text.innerHTML = rohit.innerHTML + "<br/>";
    		 }
    
    

}


    </script>

   
    <input type="button" value="Text Area" onclick="addText('textarea')">
       
    <div id="testCases">Lorem ipsum...</div>
    
    
    
    