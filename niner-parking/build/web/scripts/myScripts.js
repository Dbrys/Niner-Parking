function setViewCookie() {
    $('#solidButton').on('click', () => {
        var type = $('#solidButton').val();
        alert(type);
        Cookie.set("viewType", type);
        setClass();
        window.location.reload();
    });
    $('#gradientButton').on('click', () => {
        var type = $('#gradientButton').val();
        alert(type);
        Cookie.set("viewType", type);
        setClass();
        window.location.reload();
    });
}

function setClass() {
    var cells = document.getElementsByClassName("percentColumn");
    var barType = Cookie.get("viewType");
    alert(barType);
    if(barType !== null){
        alert('if');
        for(var i = 0; i < cells.length; i++){
            if(cells[i].innerHTML < 10){
                cells[i].classList.add('low10');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 10 && cells[i].innerHTML < 20){
                cells[i].classList.add('low20');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 20 && cells[i].innerHTML < 30){
                cells[i].classList.add('low30');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 30 && cells[i].innerHTML < 40){
                cells[i].classList.add('mid40');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 40 && cells[i].innerHTML < 50){
                cells[i].classList.add('mid50');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 50 && cells[i].innerHTML < 60){
                cells[i].classList.add('mid60');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 60 && cells[i].innerHTML < 70){
                cells[i].classList.add('mid70');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 70 && cells[i].innerHTML < 80){
                cells[i].classList.add('high80');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 80 && cells[i].innerHTML < 90){
                cells[i].classList.add('high90');
                cells[i].classList.add(barType);
            }
            else if(cells[i].innerHTML >= 90){
                cells[i].classList.add('high100');
                cells[i].classList.add(barType);
            }
            cells[i].innerHTML = cells[i].innerHTML + '%';
        }
    }else{
        alert('else');
        for(var i = 0; i < cells.length; i++){
            if(cells[i].innerHTML < 10){
                cells[i].classList.add('low10');
            }
            else if(cells[i].innerHTML >= 10 && cells[i].innerHTML < 20){
                cells[i].classList.add('low20');
            }
            else if(cells[i].innerHTML >= 20 && cells[i].innerHTML < 30){
                cells[i].classList.add('low30');
            }
            else if(cells[i].innerHTML >= 30 && cells[i].innerHTML < 40){
                cells[i].classList.add('mid40');
            }
            else if(cells[i].innerHTML >= 40 && cells[i].innerHTML < 50){
                cells[i].classList.add('mid50');
            }
            else if(cells[i].innerHTML >= 50 && cells[i].innerHTML < 60){
                cells[i].classList.add('mid60');
            }
            else if(cells[i].innerHTML >= 60 && cells[i].innerHTML < 70){
                cells[i].classList.add('mid70');
            }
            else if(cells[i].innerHTML >= 70 && cells[i].innerHTML < 80){
                cells[i].classList.add('high80');
            }
            else if(cells[i].innerHTML >= 80 && cells[i].innerHTML < 90){
                cells[i].classList.add('high90');
            }
            else if(cells[i].innerHTML >= 90){
                cells[i].classList.add('high100');
            }
            cells[i].innerHTML = cells[i].innerHTML + '%';
        }
    }
}

/**
$(document).ready(() => {
    $(window).on('load', () => {
        setViewCookie();
    });
});
**/