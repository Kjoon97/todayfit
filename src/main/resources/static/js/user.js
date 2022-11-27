let index ={
     init: function(){
         $("#btn-join").on("click",()=>{   //'회원가입' 버튼 클릭하면 해당 함수 호출 됨.
             alert("회원 가입이 완료 되었습니다.");
             this.gotoJoin();
         });
     },

     gotoJoin: function(){
         //ajax 호출 default가 비동기 호출.
         $.ajax({
            type: "GET",
            url: "/auth/joinForm",
         }).done(function(resp){
            //alert(resp);   //컨트롤러 리턴 값 resp에 저장됨.
         }).fail(function(error){
            alert(JSON.stringify(error));
         });
     },


}

index.init();