
   <style>
textarea {
   resize: none;
}

</style>

   <script type="text/javascript">


count=1;
      var nameElement=3;
     function addText(name) {
<<<<<<< HEAD
        
   if(count<7)
        {
=======
    	
>>>>>>> refs/remotes/origin/master
     var element = document.createElement("textarea");
   
     var text = document.getElementById("testCases");
    
    //text.innerHTML = text.innerHTML+"t";
   
     element.setAttribute("name", nameElement);
     element.setAttribute("placeholder",'Testcase');
     nameElement++;
     element.setAttribute("cols",40);
     element.setAttribute("rows",1);
    text.appendChild(element);
<<<<<<< HEAD
=======
    text.innerHTML = text.innerHTML+"testcase";
    
    		 
    var element1 = document.createElement("textarea");
    
    var text1 = document.getElementById("testCases");
  

    element1.setAttribute("name", nameElement);
    nameElement++;
    element1.setAttribute("cols",1);
    element1.setAttribute("rows",2);

   text1.appendChild(element1);
   text1.innerHTML = text1.innerHTML+" value <br/>"  ;
   		 
>>>>>>> refs/remotes/origin/master
    
    
             
    var element1 = document.createElement("textarea");
    
    var text1 = document.getElementById("testCases");
    
    
    text1.innerHTML = text1.innerHTML+" "; 
    
    element1.setAttribute("name", nameElement);
     element1.setAttribute("placeholder",'Value');
    nameElement++;
    element1.setAttribute("cols",40);
    element1.setAttribute("rows",1);
   text1.appendChild(element1);  

    count=count+1;}

    else{
       document.getElementById(testCaseBtn).disabled = true;
    }

}
    </script>

<<<<<<< HEAD

<form method="post" action="/CodeSalad/NewProblem" id="main-contact-form">
     <div class="col-md-6 padding">
   <div style="margin-left: 55px; ">
  
<select name="level" >
<option value="B">Beginner</option>
<option value="E">Easy</option>
<option value="M">Medium</option>
<option value="H">Hard</option>
</select>

<textarea rows="1" cols="67" placeholder="Problem Name" name="Pname"></textarea>
        <textarea rows="17.99" cols="80"  placeholder="Enter Problem text" name="code"></textarea>
     </div>
     </div>

    </div>
    <div class="col-md-6 padding" >
    <br>
    <div style="margin-right: 80px;">
    <textarea rows="1" cols="40" placeholder="Testcase" name="1"  ></textarea>
    <textarea rows="1" cols="40" placeholder="Value" name="2"  ></textarea>
    </div>
  


    <div id="testCases"  style="left: 30px;" > </div>


    <div>
    <input id="testCaseBtn" type="button" value="Text Area" onclick="addText('textarea')" class="btn btn-xs btn-primary" style="margin-left: 410px; " >
<button type="submit" class="btn btn-xs btn-success">Submit</button>

    </div>

     </div>   

    </form>    
               
       
=======
   
    <input type="button" value="Text Area" onclick="addText('textarea')">
       
    <div id="testCases"> </div>
    
    
    
    
>>>>>>> refs/remotes/origin/master
