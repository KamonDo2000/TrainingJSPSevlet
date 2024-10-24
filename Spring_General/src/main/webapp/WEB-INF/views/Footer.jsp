<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

footer{
    width: 100%;
    background: #343a40;
    padding: 20px 0px;
    margin-top: 25px;
    padding-bottom: 0px
}
.footer{
    width: 100%;
    margin-left: auto;
    margin-right: auto;
    color: white;
    font-size: 13px;
    padding-bottom: 15px;
    margin-top: 15px
}
.footer b{
    text-align: center;
    color: #01d5b0;
    font-size: 22px;
    font-weight: bolder;
    line-height: 50px;
    display: block;
    border-right: 1px solid white
}
.footer ul {
    width: 100%;
    padding-left: 13px
}
.footer li{
    width: 100%;
    line-height: 22px;
    margin-bottom: 8px;
    padding-left: 10px
}
.footer .litil{
    color: #01d5b0;
    font-weight: bolder;
    height: 45px;   
    font-size: 15px;
    padding-left: 0!important
}
.footer img{
    width: 100%;
    max-width: 150px;
    margin-left: -10px;
}
  
</style>

</head>
<body>
	 <footer>
        <div class="footer container row justify-content-center">
            <div class="col-md-3 col-sm-6">
                <b>Kamon Do</b>
            </div>
            <div class="col-md-3 col-sm-6">
                <ul>
                    <li class="litil">Về Tôi</li>
                    <li>Giới Thiệu</li>
                    <li>Liên Hệ</li>
                    <li>Chính Sách Bảo Mật</li>
                    <li>Điều Kiện Và Điều Khoản</li>
                    <li>Quy Định</li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-6">
                    <ul>
                        <li class="litil">
                            Download Mobile App
                        </li>
                        <li>
                            <img src="${assetsPath}/img/appstore@3x.png">
                        </li>
                        <li>
                            <img src="${assetsPath}/img/playstore@3x.png">
                        </li>
                    </ul>
            </div>
            <div class="col-md-3 col-sm-6">
                <ul>
                    <li class="litil">Liên Hệ </li>
                    <li>Trụ Sở: ...</li>
                    <li>Hotline : ...</li>
                    <li>Email: ...@gmail.com</li>
                    <li>(7:00 - 22:00 Kể cả thứ 7, CN)</li>
                </ul>
            </div>
           
        </div>
        <div class="footer container row justify-content-center">
            <p>@ All Copyright Reserved 2024 Kamon Do</p>
        </div>
    </footer>
</body>
</html>