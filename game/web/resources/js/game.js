$(document).ready(function(){
    $('#in').on('keydown',function(event){
        if(event.which == 32){

            $("#left").replaceWith(function(){
                return "<img class=\""+"game_item"+"\""+" id=\""+"left"+"\""+"style=\""+"width: 100%"+"\""+"src=\""+"resources/pics/35788_original.jpg"+"\""+">";
            });
            $("#right").replaceWith(function(){
                return "<img class=\""+"game_item"+"\""+" id=\""+"right"+"\""+"style=\""+"width: 100%"+"\""+" src=\""+"resources\/pics/35788_original.jpg"+"\""+">";
            });
            $('.game_item').css('display','none');

            showRandomItem();

            game_started=true;

        }
        if(event.which==shownWhich && game_started ){
            hide(shownId);
            timeFinish = Date.now()-timeStart;
            if(shownWhich==68){
                leftGamerTime+=timeFinish;
            }else{
                rightGamerTime+=timeFinish;
            }
            if(count<10){
                var rand=getRandomInt(100,2000);
                setTimeout(showRandomItem,rand);
                //showRandomItem();
            }else{
                leftGamerTime=Math.ceil(leftGamerTime/leftCount);
                rightGamerTime=Math.ceil(rightGamerTime/rightCount);
                if(leftGamerTime==rightGamerTime){
                    alert('Paritet!!');
                }else if(leftGamerTime<rightGamerTime){
                    alert('left gamer win!!!!!('+leftGamerTime+'<'+rightGamerTime+')');

                }else{
                    alert('right gamer win!!!!!('+rightGamerTime+'<'+leftGamerTime+')');
                }
            }
        }
    });


    var count=0;
    var leftCount=0;
    var rightCount=0;
    var timeStart = Date.now();
    var timeFinish = Date.now();
    var rightGamerTime=timeFinish-timeStart;
    var leftGamerTime=timeFinish-timeStart;
    var shownId='';
    var shownWhich=0;
    var game_started=false;
    function showRandomItem(){
        count++;
        var first_random_number=getRandomInt(0,1);
        if(first_random_number == 0){
            show('#left');
            shownId='#left';
            shownWhich=68;
            leftCount++;
            timeStart = Date.now();

        }else{
            show('#right');
            shownId='#right';
            shownWhich=76;
            rightCount++;
            timeStart = Date.now();

        }

    }

    function show(id){
        $(id).css('display','block');
    }

    function hide(id){
        $(id).css('display','none');
    }

    function getRandomInt(min, max)
    {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

});