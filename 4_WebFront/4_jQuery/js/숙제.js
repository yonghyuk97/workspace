const check = document.getElementsByClassName("check");


document.getElementById("select").addEventListener("click",function(){
    

    for(let i = 0; i < check.length; i++){
        
        if(check[i].checked){
            // document.getElementById("div1").innerHTML += document.getElementsByClassName("val")[i].innerHTML +", "+" ";
            document.getElementById("div1").innerHTML += document.getElementsByTagName("label")[i+1].innerHTML + " ";
        }
        
    }

})


    
   