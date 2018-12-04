function updateResult(x, y){
	var id = x.docid;
	var title = x.title;
	var url = x.url;
	var company = x.company;
	var location = x.location;
	var tempSummary = x.summary;
	tempSummary = clearBr(tempSummary.substring(2));
	var summary = tempSummary.substring(0, tempSummary.length - 11);
	var loc = document.getElementById("location" + y);
	var u = document.getElementById("url" + y);
	var com = document.getElementById("company" + y);
	var sum = document.getElementById("summary" + y);
	var t = document.getElementById("title" + y);
	loc.innerHTML = location;
	u.innerHTML = url;
	com.innerHTML = company;
	sum.innerHTML = summary;
	t.innerHTML = title;
	t.setAttribute("href", url);
	var r = document.getElementById("result" + y);
	r.style.visibility = "visible";
}

function search(){
	var form = new FormData();
	var query = document.getElementById("query").value;
	var location = document.getElementById("loc").value;
	var skills = "";
    var x = document.getElementsByName("c");
    for(var i = 0; i < x.length; i ++){
        if(x[i].checked){
            skills += x[i].value;
            skills += " ";
        }
    }
    form.append("query", query);
    form.append("location", location);
	form.append("skills", skills);
	$.ajax({
		url:"${pageContext.request.contextPath}/public/testupload",
        type:"get",
        data:form,
        processData:false,
        contentType:false,
        success:function(data){
        
        }
    });
}



function update(x){
	console.log(x[0]);
	for(var i = 0; i < 10; i ++){
		updateResult(x[i], i + 1);
	}
}


function clearResult(){
	for(var i = 1; i < 11; i ++){
		var loc = document.getElementById("location" + i);
		var u = document.getElementById("url" + i);
		var com = document.getElementById("company" + i);
		var sum = document.getElementById("summary" + i);
		var t = document.getElementById("title" + i);
		loc.innerHTML = "";
		u.innerHTML = "";
		com.innerHTML = "";
		sum.innerHTML = "";
		t.innerHTML = "";
		t.setAttribute("href", "");
	}
}

function resultVisible(x){
	var id = "result" + x;
	document.getElementById(id).style.visibility = "visible";
}

function resultHidden(x){
	var id = "result" + x;
	document.getElementById(id).style.visibility = "hidden";
}

function hiddenAll(){
	for(var i = 1; i < 11; i ++){
		resultHidden(i);
	}
}

function visibleAll(){
	for(var i = 1; i < 11; i ++){
		resultVisible(i);
	}
}

function clearBr(t) { 
	t = t.replace(/^\s*|\s*$/g,"");
	return t; 
}