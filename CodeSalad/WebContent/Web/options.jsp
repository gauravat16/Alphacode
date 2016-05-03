
<style>
textarea {
	resize: none;
}
</style>

<script type="text/javascript">
	count = 1;
	var nameElement = 3;
	function addText(name) {

		if (count < 7) {
			var element = document.createElement("textarea");

			var text = document.getElementById("testCases");

			//text.innerHTML = text.innerHTML+"t";

			element.setAttribute("name", nameElement);
			element.setAttribute("placeholder", 'Testcase');
			nameElement++;
			element.setAttribute("cols", 30);
			element.setAttribute("rows", 1);
			// element.setAttribute("style", "outline:none; border-color:#4fcccd; box-shadow:none;")
			text.appendChild(element);

			var element1 = document.createElement("textarea");

			var text1 = document.getElementById("testCases");

			text1.innerHTML = text1.innerHTML + " ";

			element1.setAttribute("name", nameElement);
			element1.setAttribute("placeholder", 'Value');
			nameElement++;
			element1.setAttribute("cols", 30);
			element1.setAttribute("rows", 1);
			// element1.setAttribute("style", "outline:none; border-color:#4fcccd; box-shadow:none;")
			text1.appendChild(element1);

			count = count + 1;
		}

		else {
			document.getElementById(testCaseBtn).disabled = true;
		}

	}
</script>
${compId}


 <c:choose>
   <c:when test="${user.uname == null}">
   You need to login to Submit a problem.
   </c:when>
   <c:otherwise>
   <c:choose>
   <c:when test="${isfromComp==true}" >
	<form method="post" action="/CodeSalad/NewProblem?isfromComp=true&compId=${compId}"
	id="main-contact-form">
	
	<div class="col-md-6 " style="margin-top: 2%; " >



		<select name="level">
			<option value="B">Beginner</option>
			<option value="E">Easy</option>
			<option value="M">Medium</option>
			<option value="H">Hard</option>
		</select>

		<textarea rows="1" cols="80	" placeholder="Problem Name" name="Pname"></textarea>
		<textarea rows="18" cols="80" placeholder="Enter Problem text"
			name="code"></textarea>
	</div>


	<div class="col-md-6 " style="margin-top: 2%; ">
		<br>
		<textarea rows="1" cols="30" placeholder="Testcase" name="1"></textarea>
		<textarea rows="1" cols="30" placeholder="Value" name="2"></textarea>




		<div id="testCases" style="left: 5px;"></div>



		<input id="testCaseBtn" type="button" value="Add"
			onclick="addText('textarea')" class="btn btn-xs btn-primary"
			style="margin-left: 440px;">
		<button type="submit" class="btn btn-xs btn-success">Submit</button>



	</div>

</form>
	</c:when>
	<c:otherwise><form method="post" action="/CodeSalad/NewProblem?isfromComp=false"
	id="main-contact-form">
	<div class="col-md-6 " style="margin-top: 2%; " >



		<select name="level">
			<option value="B">Beginner</option>
			<option value="E">Easy</option>
			<option value="M">Medium</option>
			<option value="H">Hard</option>
		</select>

		<textarea rows="1" cols="80	" placeholder="Problem Name" name="Pname"></textarea>
		<textarea rows="18" cols="80" placeholder="Enter Problem text"
			name="code"></textarea>
	</div>


	<div class="col-md-6 " style="margin-top: 2%; ">
		<br>
		<textarea rows="1" cols="30" placeholder="Testcase" name="1"></textarea>
		<textarea rows="1" cols="30" placeholder="Value" name="2"></textarea>




		<div id="testCases" style="left: 5px;"></div>



		<input id="testCaseBtn" type="button" value="Add"
			onclick="addText('textarea')" class="btn btn-xs btn-primary"
			style="margin-left: 440px;">
		<button type="submit" class="btn btn-xs btn-success">Submit</button>



	</div>

</form></c:otherwise>
	
	
	</c:choose>

   
   </c:otherwise>
   </c:choose>








