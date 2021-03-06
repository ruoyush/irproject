<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>

<!--<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="javascript" src="GetResult.js"></script>
    <script language="javascript">
        var json = ${documents};
        var l=json.length;
        var result = [];
        for(var i=0;i<l;i++){
            for(var key in json[i]){
                l.push(key+":"+json[i][key]);
            }
        }

    </script>
</head>
<body>

<p>location: ${location}</p>
<p>total result: ${size}</p>
<p>current page: ${page}</p>
<p>total page: ${totalPage}</p>
<p>query: ${query}</p>



${documents}

</body>
</html>-->



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title>Result</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="UI Elements: Search Box with Filter" />
    <meta name="keywords" content="jquery, search box, search input, filter, checkbox "/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="GetResult.js"></script>
    <script language="javascript">
        var json = ${documents};
        var l=json.length;
        var result = [];
        for(var i=0;i<l;i++){
//            for(var key in json[i]){
                result.push(json[i]);
//            }
        }
        console.log(result);

    </script>
    <script type="javascript" src="GetResult.js"></script>
    <script type="javascript">
        var x = XMLHttpRequest.getAttribute("documents");
        console.log(x);
        //			request.getAttribute("document");
    </script>
    <style>
        #parent{
            background: url('http://ourjs.github.io/static/2015/arrow.png') right center no-repeat;
            /* the width and the height of your image */
            width: 100px;
            height: 30px;
            overflow: hidden;
            border: solid 1px #ccc;
            float: right;
        }

        #parent select{
            -webkit-appearance:none;
            -moz-appearance:none;
            appearance:none;
            background:transparent;
            border:none;
            padding-left:10px;
            width: 120px;
            height:100%;

        }

        *{
            padding:0;
            margin:0;
        }
        body{
            background:transparent url(http://tympanus.net/codrops/wp-content/themes/codropstheme/images/bg_main.png) repeat scroll left top;
            font-family:"Helvetica Neue",Arial,Helvetica,Geneva,sans-serif;

        }
        h1{
            font-size:180px;
            line-height:180px;
            text-transform: uppercase;
            color:#1275AD;
            position:absolute;
            text-shadow:0 1px 1px #45A8DF;
            top:-25px;
            left:-20px;
            white-space: nowrap;
        }
        span.reference{
            position:fixed;
            left:10px;
            bottom:10px;
            font-size:11px;
        }
        span.reference a{
            color:#fff;
            text-decoration:none;
            text-transform: uppercase;
            text-shadow:0 1px 0 #000;
        }
        span.reference a:hover{
            color:#f0f0f0;
        }
        .box{
            margin:0 auto 0 auto;
            height:430px;
            width:100%;
            position:relative;
            -moz-box-shadow:0px 0px 5px #444;
            -webkit-box-shadow:0px 0px 5px #444;
            box-shadow:0px 0px 5px #444;
            background:#1783BF url(click.png) no-repeat 380px 80px;
        }
        .box h2{
            background-color:#1275AD;
            border-color:#0E5A85 #0E5A85 #0E5A85;
            border-style:ridge ridge solid;
            border-width:1px;
            color:#FFFFFF;
            font-size:22px;
            padding:10px;
            text-shadow:1px 1px 1px #000000;
        }

    </style>
    <script type="text/javascript">
        //var result = request.getAttribute("result");
        //if(result != null){


        //}
    </script>
</head>
<body>
<div class="content">

    <div class="box">
        <h2>Search Box with Filter Demo</h2>
        <form id="ui_element" class="sb_wrapper" method="get" onsubmit="test(this)" action="search">
            <div id="parent">
                <select id = "loc" name = "postion">
                    <option value="Seattle, WA">Seattle, WA</option>
                    <option value="Los Angeles, CA">Los Angeles, CA</option>
                    <option value="San Francisco, CA">San Francisco, CA</option>
                    <option value="Pittsburgh, PA">Pittsburgh, PA</option>
                    <option value="Washington, DC">Washington, DC</option>
                    <option value="Atlanta, GA">Atlanta, GA</option>
                    <option value="Chicago, IL">Chicago, IL</option>
                    <option value="Charlotte, NC">Charlotte, NC</option>
                    <option value="Dallas, TX">Dallas, TX</option>
                    <option value="Houston, TX">Houston, TX</option>
                    <option value="New York, NY">New York, NY</option>
                    <option value="Austin, TX">Austin, TX</option>
                    <option value="Philadelphia, PA">Philadelphia, PA</option>
                    <option value="Jacksonville, FL">Jacksonville, FL</option>
                    <option value="Columbus, OH">Columbus, OH</option>
                    <option value="Detroit, MH">Detroit, MH</option>
                    <option value="Boston, MA">Boston, MA</option>
                    <option value="Fresno, CA">Fresno, CA</option>
                    <option value="Sacramento, CA">Sacramento, CA</option>
                    <option value="Mesa, AZ">Mesa, AZ</option>
                    <option value="Long Beach, CA">Long Beach, CA</option>
                    <option value="Tampa, FL">Tampa, FL</option>
                    <option value="Indianapolis, IN">Indianapolis, IN</option>
                    <option value="Fort Worth, TX">Fort Worth, TX</option>
                    <option value="Phoenix, AZ">Phoenix, AZ</option>
                    <option value="San Antonio, TX">San Antonio, TX</option>
                    <option value="San Diego, CA">San Diego, CA</option>
                    <option value="San Jose, CA">San Jose, CA</option>
                    <option value="Denver, CO">Denver, CO</option>
                    <option value="El Paso, TX">El Paso, TX</option>
                    <option value="Nashville, TN">Nashville, TN</option>
                    <option value="Memphis, TN">Memphis, TN</option>
                    <option value="Portland, OR">Portland, OR</option>
                    <option value="Las Vegas, NV">Las Vegas, NV</option>
                    <option value="Baltimore, MD">Baltimore, MD</option>
                    <option value="Tucson, AZ">Tucson, AZ</option>
                    <option value="Colorado Springs, CO">Colorado Springs, CO</option>
                    <option value="Miami, FL">Miami, FL</option>
                    <option value="Oakland, CA">Oakland, CA</option>
                    <option value="Minneapolis, MN">Minneapolis, MN</option>
                    <option value="Cincinnati, OH">Cincinnati, OH</option>
                    <option value="Jersey City, NJ">Jersey City, NJ</option>
                    <option value="Irvine, CA">Irvine, CA</option>
                    <option value="Buffalo, NY">Buffalo, NY</option>
                </select>
            </div>
            <div style="text-align: center">
                <p>
                    <span class="sb_down"></span>
                    <input id = "query" name = "query" class="sb_input" type="text"/>
                    <input class="sb_search" type="submit" value=""/>
                </p>
            </div>
            <ul class="sb_dropdown" style="display:none;">
                <li class="sb_filter">Choose Your Skills</li>
                <li><input name = "c" type="checkbox" value="Java"/>Java</li>
                <li><input name = "c" type="checkbox" value="C#"/>C#</li>
                <li><input name = "c" type="checkbox" value="Hadoop"/>Hadoop</li>
                <li><input name = "c" type="checkbox" value="Spark"/>Spark</li>
                <li><input name = "c" type="checkbox" value="Machine Learning"/>Machine Learning</li>
                <li><input name = "c" type="checkbox" value=".Net"/>.Net</li>
                <li><input name = "c" type="checkbox" value="Android"/>Android</li>
                <li><input name = "c" type="checkbox" value="IOS"/>IOS</li>
                <li><input name = "c" type="checkbox" value="Spring"/>Spring</li>
                <li><input name = "c" type="checkbox" value="C++"/>C++</li>
                <li><input name = "c" type="checkbox" value="C"/>C</li>
                <li><input name = "c" type="checkbox" value="Go"/>Go</li>
                <li><input name = "c" type="checkbox" value="Database"/>Database</li>
                <li><input name = "c" type="checkbox" value="Angularjs"/>Angularjs</li>
            </ul>
            <div style="visibility: hidden;>
                <input name="page" value="2" type="text" style = "width = 30px;">
            </div>
            <input id = "skills" name = "skills" style="visibility: hidden" type="text">

        </form>
    </div>
</div>
<div>
    <div id="result1" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title1" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content1">
            <div>
                <div><h4 id = "url1">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location1">Charlotte, NC</h4></div>
                <div><h4 id = "company1">Oyster Tech Inc</h4></div>
                <span id = "summary1">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test1">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>

    <div id = "result2" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title2" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content2">
            <div>
                <div><h4 id = "url2">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location2">Charlotte, NC</h4></div>
                <div><h4 id = "company2">Oyster Tech Inc</h4></div>
                <span id = "summary2">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test2">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result3" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title3" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content3">
            <div>
                <div><h4 id = "url3">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location3">Charlotte, NC</h4></div>
                <div><h4 id = "company3">Oyster Tech Inc</h4></div>
                <span id = "summary3">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test3">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result4" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title4" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content4">
            <div>
                <div><h4 id = "url4">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location4">Charlotte, NC</h4></div>
                <div><h4 id = "company4">Oyster Tech Inc</h4></div>
                <span id = "summary4">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test4">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result5" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title5" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content5">
            <div>
                <div><h4 id = "url5">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location5">Charlotte, NC</h4></div>
                <div><h4 id = "company5">Oyster Tech Inc</h4></div>
                <span id = "summary5">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test5">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result6" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title6" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content6">
            <div>
                <div><h4 id = "url6">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location6">Charlotte, NC</h4></div>
                <div><h4 id = "company6">Oyster Tech Inc</h4></div>
                <span id = "summary6">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test6">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result7" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title7" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content7">
            <div>
                <div><h4 id = "url7">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location7">Charlotte, NC</h4></div>
                <div><h4 id = "company7">Oyster Tech Inc</h4></div>
                <span id = "summary7">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test7">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result8" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title8" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content8">
            <div>
                <div><h4 id = "url8">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location8">Charlotte, NC</h4></div>
                <div><h4 id = "company8">Oyster Tech Inc</h4></div>
                <span id = "summary8">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test8">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result9" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title9" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content9">
            <div>
                <div><h4 id = "url9">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location9">Charlotte, NC</h4></div>
                <div><h4 id = "company9">Oyster Tech Inc</h4></div>
                <span id = "summary9">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test9">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>
    <div id = "result10" style="width: 1000px; height: 180px; position: relative; left: 15%; visibility: hidden;">
        <h3><a id = "title10" href = "">Sr. Tech Manager - App Prog (Distinguished Engineer - Java,...</a></h3>
        <div id = "content10">
            <div>
                <div><h4 id = "url10">https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d</h4></div>
                <div><h4 id = "location10">Charlotte, NC</h4></div>
                <div><h4 id = "company10">Oyster Tech Inc</h4></div>
                <span id = "summary10">Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ...</span>
                <span id = "test10">            Financial Services Industry experience is a big plus. If you are interested, please go ahead and send me your most recent updated resume along with your ... read more\n            </span>
            </div>
        </div>
    </div>

</div>

<!-- The JavaScript -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
    //var test = document.getElementById("test1").innerHTML;
    function test(f) {
        var s = document.getElementById("skills");
        var skills = "";
        var x = document.getElementsByName("c");
        for(var i = 0; i < x.length; i ++){
            if(x[i].checked){
                skills += x[i].value;
                skills += " ";
            }
        }
        s.value = skills;
    }
    //test();
    update(result);
    function ClearBr(t) {
        t = t.replace(/^\s*|\s*$/g,"");
        //t = t.replace(/[\r\n]/g, "");
        return t;
    }
    var t = document.getElementById("title1");
    t.setAttribute("href", "https://www.indeed.com/company/Oyster-Tech-Inc/jobs/Senior-Tech-Manager-3eca5d5aa501d206?fccid=fab5d90c8efb7d0d");
    //            var newTest = ClearBr(test);
    //            newTest = newTest.substring(0, newTest.length - 11);
    function doit(){
        for(var i = 1; i < 11; i ++){
            var x = "result" + i;
            document.getElementById(x).style.visibility = "visible";
        }
    }
    doit();


    $(function() {
        /**
         * the element
         */
        var $ui 		= $('#ui_element');

        /**
         * on focus and on click display the dropdown,
         * and change the arrow image
         */
        $ui.find('.sb_input').bind('focus click',function(){
            $ui.find('.sb_down')
                .addClass('sb_up')
                .removeClass('sb_down')
                .andSelf()
                .find('.sb_dropdown')
                .show();
        });

        /**
         * on mouse leave hide the dropdown,
         * and change the arrow image
         */
        $ui.bind('mouseleave',function(){
            $ui.find('.sb_up')
                .addClass('sb_down')
                .removeClass('sb_up')
                .andSelf()
                .find('.sb_dropdown')
                .hide();
        });

        /**
         * selecting all checkboxes
         */
        $ui.find('.sb_dropdown').find('label[for="all"]').prev().bind('click',function(){
            $(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
        });
    });
</script>
</body>
</html>