<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
%>
<body>


<div id="site-content">
    <div id="site-content-inner">

        <div class="master-container-fluid">
            <div class="row">
                <div class="col-md-9 order-md-2 flex-column-content-md">
                    <main id="main">
                        <div class="title-box">
                            <h4 class="title h3">All Albums</h4>
                        </div>
                        <div class="row auto-fit-columns adonis-animate" data-animation="slideRight" data-animation-item=".col-auto" data-item-width="230" data-item-max-width="260">
                          
                                        
                            
                       
                     <c:forEach var="article" items="${article}" varStatus="status">
                         
                          <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="${article.a_imgDir}" 
                                        data-2x="assets/images/new-releases/new-releases-44@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle">
                                                <span class="adonis-icon icon-4x">
                                                <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
                                                <use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title">
                                    <a class="nav-link adonis-ajax-load" href="/WaterMelon/single-album.water?albumID=${article.albumID}"
                                    data-target="single-album.jsp" data-content="/WaterMelon/single-album.water?albumID=${article.albumID}">${article.albumName}</a></h6>
                                  <p class="sub-title category">
                                    <a href="../../single-album.jsp">${artists[status.index].artistName}</a></p>
                                    
                                </div>
                            </div>
                           </c:forEach>
                                               
                    
                            
                            
                             
                            
                            
                            
      
      
   
                           
                      <!--       data-2x="assets/images/new-releases/new-releases-43@2x.jpg"
                      
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-42.jpg" data-2x="assets/images/new-releases/new-releases-42@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-41.jpg" data-2x="assets/images/new-releases/new-releases-41@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-40.jpg" data-2x="assets/images/new-releases/new-releases-40@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-39.jpg" data-2x="assets/images/new-releases/new-releases-39@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-38.jpg" data-2x="assets/images/new-releases/new-releases-38@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-37.jpg" data-2x="assets/images/new-releases/new-releases-37@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-36.jpg" data-2x="assets/images/new-releases/new-releases-36@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-35.jpg" data-2x="assets/images/new-releases/new-releases-35@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-34.jpg" data-2x="assets/images/new-releases/new-releases-34@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-33.jpg" data-2x="assets/images/new-releases/new-releases-33@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-32.jpg" data-2x="assets/images/new-releases/new-releases-32@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-31.jpg" data-2x="assets/images/new-releases/new-releases-31@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-30.jpg" data-2x="assets/images/new-releases/new-releases-30@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-29.jpg" data-2x="assets/images/new-releases/new-releases-29@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-28.jpg" data-2x="assets/images/new-releases/new-releases-28@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-27.jpg" data-2x="assets/images/new-releases/new-releases-27@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-26.jpg" data-2x="assets/images/new-releases/new-releases-26@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-25.jpg" data-2x="assets/images/new-releases/new-releases-25@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div> -->
                            <!-- <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-24.jpg" data-2x="assets/images/new-releases/new-releases-24@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-23.jpg" data-2x="assets/images/new-releases/new-releases-23@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-22.jpg" data-2x="assets/images/new-releases/new-releases-22@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-21.jpg" data-2x="assets/images/new-releases/new-releases-21@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-20.jpg" data-2x="assets/images/new-releases/new-releases-20@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-19.jpg" data-2x="assets/images/new-releases/new-releases-19@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-18.jpg" data-2x="assets/images/new-releases/new-releases-18@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                            <div class="col-auto">
                                <div class="music-img-box mb-e-30 mb-e-lg-40">
                                    <div class="img-box box-rounded-sm">
                                        <img class="retina" src="../assets/images/new-releases/new-releases-17.jpg" data-2x="assets/images/new-releases/new-releases-17@2x.jpg" alt="">
                                        <div class="hover-state">
                                            <div class="absolute-bottom-left pl-e-20 pb-e-20">
                                                <span class="pointer play-btn-dark round-btn"><i class="play-icon"></i></span>
                                            </div>
                                            <div class="absolute-top-right pr-e-20 pt-e-20">
                                                <span class="pointer dropdown-menu-toggle"><span class="adonis-icon icon-4x"><svg xmlns="http://www.w3.org/2000/svg" version="1.1"><use xlink:href="#icon-horizontal-dots"></use></svg></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <h6 class="title"><a href="#">Roll n Peace Remix</a></h6>
                                    <p class="sub-title category"><a href="#">Imagine</a></p>
                                </div>
                            </div>
                        </div> -->
                        
                    </main>
                </div>
                      
</body>
</html>