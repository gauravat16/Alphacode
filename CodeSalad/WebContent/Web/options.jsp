
   <style>
textarea {
   resize: none;
}

</style>

   <script type="text/javascript" >


count=1;
      var nameElement=3;
     function addText(name) {
        
   if(count<7)
        {
     var element = document.createElement("textarea");
   
     var text = document.getElementById("testCases");
    
    //text.innerHTML = text.innerHTML+"t";
   
     element.setAttribute("name", nameElement);
     element.setAttribute("placeholder",'Testcase');
     nameElement++;
     element.setAttribute("cols",40);
     element.setAttribute("rows",1);
    // element.setAttribute("style", "outline:none; border-color:#4fcccd; box-shadow:none;")
    text.appendChild(element);
    
    
             
    var element1 = document.createElement("textarea");
    
    var text1 = document.getElementById("testCases");
    
    
    text1.innerHTML = text1.innerHTML+" "; 
    
    element1.setAttribute("name", nameElement);
     element1.setAttribute("placeholder",'Value');
    nameElement++;
    element1.setAttribute("cols",40);
    element1.setAttribute("rows",1);
   // element1.setAttribute("style", "outline:none; border-color:#4fcccd; box-shadow:none;")
   text1.appendChild(element1);  

    count=count+1;}

    else{
       document.getElementById(testCaseBtn).disabled = true;
    }

}
    </script>
<c:choose>
<c:when test="${isCompetition}==true">
<form method="post" action="/CodeSalad/NewProblem?isCompetition=true" id="main-contact-form">
</c:when>
<c:otherwise>
<form method="post" action="/CodeSalad/NewProblem" id="main-contact-form">
</c:otherwise>
</c:choose>


     <div class="col-md-6 padding" style="padding: 2.3cm 0cm 0cm 0cm">                <!-- padding added -->
   <div style="margin-left: 55px " class="button">
  

<select name="level" >                                     <!-- padding added -->
<option value="B">Beginner</option>
<option value="E">Easy</option>
<option value="M">Medium</option>
<option value="H">Hard</option>
</select>

<textarea rows="1" cols="68.99" placeholder="Problem Name" name="Pname" ></textarea>
        <textarea rows="17.99" cols="80"  placeholder="Enter Problem text" name="code" ></textarea>
     </div>
     </div>

    </div>
    <div class="col-md-6 padding" >
    <br>
    <div  style="margin-right: 250px display:inline-block;;" >
    <textarea rows="1" cols="40" placeholder="Testcase" name="1"  ></textarea>
    <textarea rows="1" cols="40" placeholder="Value" name="2" ></textarea>
    </div>
  


    <div id="testCases"  style="left: 30px;" > </div>


    <div>
    <input id="testCaseBtn" type="button" value="Add" onclick="addText('textarea')" class="btn btn-xs btn-primary" style="margin-left: 520px; " >
<button type="submit" class="btn btn-xs btn-success">Submit</button>

    </div>

     </div>   

    </form>    
               
       