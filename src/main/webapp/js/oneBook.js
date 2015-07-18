/**
 * Created by xiaoming on 2015/7/13.
 */
function showList(){
    if($('.listpre').css('display')=="none"){
        $('.listpre').show();
        $('.listpro').hide();
        $("#showList").removeClass("glyphicon glyphicon-chevron-up");
        $("#showList").addClass("glyphicon glyphicon-chevron-down");
    }else{
        $('.listpro').show();
        $('.listpre').hide();
        $("#showList").removeClass("glyphicon glyphicon-chevron-down");
        $("#showList").addClass("glyphicon glyphicon-chevron-up");
    }
}
function buyit(id){
   window.open("/buynow/"+id);
}