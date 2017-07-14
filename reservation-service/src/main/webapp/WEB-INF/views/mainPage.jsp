<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	<title>네이버 예약 메인페이지 </title>
	<link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<div class="header">
			<header class="header_tit">
				<h1 class="logo">
			     	<a href="#" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
            		<a href="#" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				</h1>
				<a href="#" class ="btn_my"><span title="내 예약">MY</span></a>
			</header>
		</div>
		<hr>
		<div class="event">
			<div class="section_visual">
				<div class="group_visual">
					<div class="container_visual">
						<div class="prev_e">
							<div class="prev_inn">
                               <a href="#" class="btn_pre_e" title="이전" > <i class="spr_book_event spr_event_pre">이전</i> </a>
							</div>
						</div>
						<div class="nxt_e">
							<div class="nxt_inn">
								<a href="#" class="btn_nxt_e" title="다음" > <i class="spr_book_event spr_event_nxt ">다음</i></a>
							</div>
						</div>
						<div>
 						  <div class="container_visual">
                              <!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 --->
                              <ul class="visual_img">
	                              <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170119_48/1484802596907hmVDm_JPEG/image.jpg); width: 349px;">
	                                      <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
	                                          <div class="event_txt">
	                                              <h4 class="event_txt_tit p1">1.뮤지컬-김종욱찾기 네이버 예약</h4>
	                                              <p class="event_txt_adr">대학로 쁘띠첼씨어터</p>
	                                              <p class="event_txt_dsc p1">네이버 예매시, 손크림/발크림(중 래덤)을 드립니다</p>
	                                          </div>
	                                      </a>
                                  </li>
                                  <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg); width: 349px;">
                                      <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                          <div class="event_txt">
                                              <h4 class="event_txt_tit p2">2번 이미지 </h4>
                                              <p class="event_txt_adr p2">2번 장소 </p>
                                              <p class="event_txt_dsc p2">2번 상세 </p>
                                          </div>
                                      </a>
                                  </li>
                                  
                                  <li class="item" style="background-image: url(http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg); width: 349px;">
                                      <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                                          <div class="event_txt">
                                              <h4 class="event_txt_tit p3">3번 이미지 </h4>
                                              <p class="event_txt_adr p3">3333</p>
                                              <p class="event_txt_dsc p3">3번 상세 </p>
                                          </div>
                                      </a>
                                  </li>
                              </ul>
                           </div>	
                           <span class="nxt_fix"></span>											
						</div>	
					</div><!--end of container_visual -->
				</div>
			</div>
			<div class="section_event_tab">
				<ul class="event_tab_lst tab_lst_min">
					<li class="item" data-category="1">
						<a class="anchor active"> <span>전체</span></a>
					</li>
					
				</ul>	
			</div> <!-- end of category List -->
			<div class="section_event_lst">
				 <p class="event_lst_txt ">바로 예매 가능한 전시, 공연, 행사가 <span class="pink">개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box">
                        
                    </ul>
                    <ul class="lst_event_box">
                       
                    </ul>
                    <!-- 더보기 -->
                    <div class="more">
                        <button class="btn"><span>더보기</span></button>
                    </div>
                </div>
			</div>
		</div>
	</div>
	 <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
   <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  -->
   <!-- jquery npm -->
    <script src="/resources/js/node_modules/jquery/dist/jquery.js"></script>
   <!-- handlebar npm -->
   <jsp:include page="include/handlebarsjs-template-html.jsp" flush="false" />
   <script src="/resources/js/node_modules/handlebars/dist/handlebars.js"></script>
	<script src="/resources/js/main.js"></script>
    <script src="/resources/js/mainbottom.js"></script>
  
</body>
</html>