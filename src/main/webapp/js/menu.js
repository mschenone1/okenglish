document.onclick = hideMenu; 
function hideMenu() {
    document.getElementById("contextMenu").style.display = "none";
}
  
function showMenu() {
  
    if (document.getElementById("contextMenu").style.display === "block")
        hideMenu();
    else {
        var menu = document.getElementById("contextMenu");
                      
        menu.style.display = 'block';
        menu.style.left = e.pageX + "px";
        menu.style.top = e.pageY + "px";
         }
}