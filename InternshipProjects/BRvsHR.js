var paragraph = document.getElementById("testparagraph");

function addbreak(){
  var br = document.createElement("br");
  paragraph.appendChild(br);
}

function addhorizontalrule(){
  var hr = document.createElement("hr");
  paragraph.appendChild(hr);
}

function undoBbutton(){
  paragraph.innerHTML = "";
}
