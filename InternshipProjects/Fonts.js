function changeFont(){
  var textFont = document.getElementById('fontSelect').value;
  var paragraph = document.getElementById("modified-text");
  if(textFont == "Papyrus"){
    paragraph.style.fontFamily = "Papyrus";
    document.getElementById('font-display').innerHTML = 'Font-family: "' + textFont + '";';
  }
  else if(textFont == "Arial"){
    paragraph.style.fontFamily = "Arial";
    document.getElementById('font-display').innerHTML = 'Font-family: "' + textFont + '";';
  }
  else if(textFont == "Times New Roman"){
  	paragraph.style.fontFamily = "Times New Roman";
    document.getElementById('font-display').innerHTML = 'Font-family: "' + textFont + '";';
  }
  else if(textFont == "Courier New"){
  	paragraph.style.fontFamily = "Courier New";
    document.getElementById('font-display').innerHTML = 'Font-family: "' + textFont + '";';
  }
  
}

function submit(){
  var formatSelect = document.getElementById('sizeFormat');
  var format = formatSelect.options[formatSelect.selectedIndex].value;
  var textSize = document.getElementById('text-size').value;
  var paragraph = document.getElementById("modified-text");
  
  var completeSize = textSize + format;
  
  paragraph.style.fontSize = completeSize;
  
  document.getElementById('size-display').innerHTML = 'Font-size: ' + completeSize + ';'; 
  
}
