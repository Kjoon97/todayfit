let index ={
     init: function(){
         $("#btn-save").on("click",()=>{   //'회원가입' 버튼 클릭하면 해당 함수 호출 됨.
             this.save();
         });
          $("#btn-update").on("click",()=>{   //'회원수정' 버튼 클릭하면 해당 함수 호출 됨.
                this.update();
          });
          $("#btn-region-update").on("click",()=>{   //'회원수정' 버튼 클릭하면 해당 함수 호출 됨.
                this.regionUpdate();
          });
     },

     save: function(){
         //alert('user의 save 함수 호출')
         let data = {
               nickname: $("#nickname").val(),
               password: $("#password").val(),
               email: $("#email").val(),
               region: $('#region').val()
         };
         if(!data.nickname || data.nickname.trim() === "" || !data.password || data.password.trim() === "" || !data.email || data.email.trim() === ""){
            alert("공백 또는 입력하지 않은 부분이 있습니다.")
            return false;
         } else if (!/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\W)(?=\S+$).{8,16}/.test(data.password)) {
            alert("비밀 번호는 8~16자 영문 대 소문자, 특수 문자를 사용하세요.");
            $('#password').focus();
            return false;
         } else if (!/^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$/.test(data.nickname)){
            alert("닉네임은 특수문자를 제외한 2~10자리여야 합니다.");
            $('#username').focus();
            return false;
         }
         console.log(data)

         //ajax 호출 default가 비동기 호출.
         $.ajax({
            type: "POST",
            url: "/auth/join",
            data: JSON.stringify(data),                     //http body데이터
            contentType: "application/json; charset=utf-8", //body 데이터의 타입
            dataType: "json"                                //서버로부터의 응답을 json으로 받고 js로 변환
         }).done(function(resp){
            //alert(resp);   //컨트롤러 리턴 값 resp에 저장됨.
            alert("회원 가입이 완료 되었습니다.");
            location.href ="/auth/loginForm";
         }).fail(function(error){
            alert(JSON.stringify(error));
         });    //ajax 통신으로 3개의 데이터 json으로 변환 후 insert 요청.
     },

     update: function(){
           let data = {
               id: $("#id").val(),
               email: $("#email").val(),
               password: $("#password").val(),
               nickname: $("#nickname").val()
           };

           $.ajax({
               type: "PUT",
               url: "/user",
               data: JSON.stringify(data),
               contentType: "application/json; charset=utf-8",
               dataType: "json"
           }).done(function(resp){
                alert("회원 수정이 완료 되었습니다.");
                location.href ="/my-page";
           }).fail(function(error){
                alert(JSON.stringify(error));
           });
     },

     regionUpdate: function(){
                let data = {
                    id: $("#id").val(),
                    email: $("#email").val(),
                    password: $("#password").val(),
                    nickname: $("#nickname").val(),
                    region: $("#region").val()
                };

                $.ajax({
                    type: "PUT",
                    url: "/region",
                    data: JSON.stringify(data),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json"
                }).done(function(resp){
                     alert("지역 수정이 완료 되었습니다.");
                     location.href ="/my-page";
                }).fail(function(error){
                     alert(JSON.stringify(error));
                });
     }

}

function checkEmail(){
    var email = $('#email').val();
    $.ajax({
        url:'/emailCheck',
        type:'post',
        data:{email:email},
        success:function(cnt){
            if(cnt == 0){
                $('.email_ok').css("display","inline-block");
                $('.email_already').css("display", "none");
            } else {
                $('.email_already').css("display","inline-block");
                $('.email_ok').css("display", "none");
                $('#email').val('');
            }
        }
//        error:function(){
//            alert("에러 입니다.");
//        }
    });
};

index.init();