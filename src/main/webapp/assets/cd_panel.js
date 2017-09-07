/**
 * Created by Administrator on 2017/9/7.
 */
var sublime = function () {
    var linkLocation, searchOpen = false, app = $(".app"), maxHeight = 0;
    var sidebar=false,boxed=false,scroll=false;
    function redirectPage() {
        window.location = linkLocation;
    }

    function events() {
        $(".offscreen-left, .main-navigation").ontouchstart = function () {
        };
        FastClick.attach(document.body);
        $(".accordion > dd").hide();
        $(window).on("load", function () {
            $(".pageload").fadeOut("slow");
        });
        $(window).resize(function () {
            equalHeightWidgets();
            if (!$.browser.mobile && !checkBreakout()) {
                $(".no-touch .main-navigation").slimScroll({height: 'auto'});
                $(".no-touch .slimscroll").slimScroll({height: 'auto'});
                initFooterFix();
            }
        });
        $(document).mouseup(function () {
            if (searchOpen === true) {
                $('.toggle-search').click();
            }
        });
        $('.toggle-search').mouseup(function () {
            return false;
        });
        $('.header-search').mouseup(function () {
            return false;
        });
    }

    function simulateLoad(el) {
        $(el).block({
            message: '<div class="loader"></div>',
            css: {border: "none", backgroundColor: "none"},
            overlayCSS: {backgroundColor: "#fff", opacity: 0.5}
        });
    }

    function checkBreakout() {
        var state = false;
        if (app.hasClass("small-menu") || app.hasClass("fixed-scroll")) {
            state = true;
        }
        return state;
    }

    function initLinkTransition() {
        $(document).on("click", "a.transition", function (e) {
            e.preventDefault();
            e.stopPropagation();
            linkLocation = this.href;
            $("body").fadeOut(1000, "easeInOutExpo", redirectPage);
            return;
        });
    }

    function initAccordion() {
        $(".accordion > dd").first().show();
        $(".accordion > dt > a").first().addClass("active");
        $(document).on("click", ".accordion > dt > a", function (e) {
            e.preventDefault();
            e.stopPropagation();
            $(this).closest(".accordion").find("dd").slideUp(800, "easeInOutExpo");
            $(this).closest(".accordion").find("a").removeClass("active");
            if ($(this).parent().next().css("display") !== "block") {
                $(this).parent().next().slideDown();
                $(this).addClass("active");
                return false;
            }
            return false;
        });
    }

    function initAnimationAPI() {
        if (!$.browser.mobile && $.fn.appear) {
            $("[data-animation]").appear();
            $("[data-animation]").on("appear", function () {
                var elm = $(this), animation = elm.data("animation") || "fadeIn", delay = elm.data("delay") || 0;
                if (!elm.hasClass("done")) {
                    setTimeout(function () {
                        elm.addClass("animated " + animation + " done");
                    }, delay);
                }
            });
        } else {
            $("[data-animation]").each(function () {
                var elm = $(this), animation = elm.data("animation") || "fadeIn";
                if (!elm.hasClass("done")) {
                    elm.addClass("animated " + animation + " done");
                }
            });
        }
    }

    function initAnimateNumbers() {
        if (!$.browser.mobile && $.fn.appear) {
            $(".count").appear();
            $(".count").on("appear", function () {
                if (!$(this).hasClass("done")) {
                    var speed = $(this).data("speed") || 2000, interval = $(this).data("interval") || 100;
                    $(this).addClass("done").countTo({speed: speed, refreshInterval: interval});
                }
            });
        } else {
            $(".count").each(function () {
                if (!$(this).hasClass("done")) {
                    $(this).addClass("done").countTo({speed: 1000});
                }
            });
        }
    }

    function initAnimateProgressBars() {
        if (!$.browser.mobile && $.fn.appear) {
            $(".progress-bar").appear();
            $(".progress-bar").on("appear", function () {
                var elm = $(this), percent = elm.data("percent");
                if (!elm.hasClass("done")) {
                    elm.addClass("done").css("width", Math.ceil(percent) + "%");
                }
            });
        } else {
            $(".progress-bar").each(function () {
                var elm = $(this), percent = elm.data("percent");
                if (!elm.hasClass("done")) {
                    elm.addClass("done").css("width", Math.ceil(percent) + "%");
                }
            });
        }
    }

    function initBrowserFix() {
        if (navigator.userAgent.search("Firefox") >= 0) {
            $(".layout > aside, .layout > section").wrapInner("<div class=\"fffix\"/>");
        }
    }

    function initDatePicker() {
        if ($.isFunction($.fn.datepicker)) {
            $(".datepicker").datepicker();
        }
    }

    function initFuelUX() {
        if ($.isFunction($.fn.wizard)) {
            $(".wizard").wizard();
        }
        if ($.isFunction($.fn.pillbox)) {
            $(".pillbox").pillbox();
        }
        if ($.isFunction($.fn.spinner)) {
            $(".spinner").spinner();
        }
    }

    function initChosen() {
        if ($.isFunction($.fn.chosen)) {
            $(".chosen").chosen();
        }
    }

    function equalHeightWidgets() {
        $('.equal-height-widgets').each(function () {
            maxHeight = 0;
            $(this).find('.widget').each(function () {
                if ($(this).innerHeight() > maxHeight) {
                    maxHeight = $(this).innerHeight();
                }
            });
            $(this).find('.widget').each(function () {
                $(this).height(maxHeight);
            });
        });
    }

    function initBoxCollapse() {
        $(document).on("click", ".widget-collapsible", function (e) {
            var el = $(this).parents(".widget").children(".widget-body");
            if (el.is(':visible')) {
                $(this).removeClass("ti-angle-down").addClass("ti-angle-up");
                el.slideUp(200);
            } else if (!el.is(':visible')) {
                $(this).removeClass("ti-angle-up").addClass("ti-angle-down");
                el.slideDown(200);
            }
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initBoxRefresh() {
        $(document).on("click", ".widget-refresh", function (e) {
            var elm = $(this).parents(".widget");
            simulateLoad(elm);
            window.setTimeout(function () {
                $(elm).unblock();
            }, 3000);
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initBoxRemove() {
        $(document).on("click", ".widget-remove", function (e) {
            $(this).parents(".widget").addClass("animated fadeOutRight").attr("id", "obsolete");
            setTimeout(function () {
                $("#obsolete").remove();
            }, 600);
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initPlacehoderFallback() {
        $('input, textarea').placeholder();
    }

    function initHeaderSearch() {
        $(document).on("click", ".toggle-search", function () {
            if (!searchOpen) {
                $('.header-search').addClass('open');
                $('.search-container .search').focus();
                searchOpen = true;
            } else {
                $('.header-search').removeClass('open');
                $('.search-container .search').focusout();
                searchOpen = false;
            }
        });
    }

    function initMenuCollapse() {
        //顶部导航浮动显示,觉得体验不好注释掉
        $(document).on("mouseover", ".topnav a", function (e) {
            var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.topnav li').not(links), subMenu = $(this).next();
            if (!parentLink.hasClass("open")) {
                parentLink.addClass("open");
            }
            if (otherLinks.hasClass("open")) {
                otherLinks.removeClass("open");
            }
            $(this).children(".sub-menu").show();
            if (subMenu.is("ul") && (!subMenu.is(":visible")))
                subMenu.slideDown();
            if ($(this).attr('href') === '#') {
                e.preventDefault();
            }
            subMenu.find('.sub-menu').each(function(){
                $(this).show();
            });
            if (subMenu.is("ul")) {
                return false;
            }
            e.stopPropagation();
            return true;
        });
        $(document).on("click", ".main-navigation a", function (e) {
            var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.main-navigation li').not(links), subMenu = $(this).next();
            if (!subMenu.hasClass("sub-menu")) {
                offscreen.hide();
                return;
            }
            if (app.hasClass("small-menu") && parentLink.parent().hasClass("nav") && $(window).width() > 767) {
                return;
            }
            otherLinks.removeClass('open');
            otherLinks.find('.sub-menu').slideUp();
            if (subMenu.is("ul") && (!subMenu.is(":visible")) && (!app.hasClass("small-sidebar"))) {
                subMenu.slideDown();
                parentLink.addClass("open");
            }
            else if (subMenu.is("ul") && (subMenu.is(":visible")) && (!app.hasClass("small-sidebar"))) {
                parentLink.removeClass("open");
                subMenu.slideUp();
            }
            if ($(this).hasClass('active') === false) {
                $(this).parents("ul.dropdown-menu").find('a').removeClass('active');
                $(this).addClass('active');
            }
            if ($(this).attr('href') === '#') {
                e.preventDefault();
            }
            if (subMenu.is("ul")) {
                return false;
            }
            e.stopPropagation();
            return true;
        });
        $(".main-navigation > .nav > li.open").each(function () {
            $(".sub-menu").hide();
            $(this).children(".sub-menu").show();
        });
        $(".no-touch .main-navigation, .no-touch .slimscroll").each(function () {
            if (checkBreakout() || app.hasClass("fixed-scroll") || $.browser.mobile) {
                return;
            }
            var data = $(this).data();
            $(this).slimScroll(data);
        });
        $(document).on("click", ".header .dropdown-menu a", function (e) {
            var links = $(this).parents('li'), parentLink = $(this).closest("li"), otherLinks = $('.header .dropdown  li').not(links),
                subMenu = $(this).next();
            otherLinks.removeClass('open');
            otherLinks.find('.sub-menu').slideUp();
            if (subMenu.is("ul") && (!subMenu.is(":visible")) ) {
                subMenu.slideDown();
                parentLink.addClass("open");
            }
            else if (subMenu.is("ul") && (subMenu.is(":visible"))) {
                parentLink.removeClass("open");
                subMenu.slideUp();
            }
            if ($(this).hasClass('active') === false) {
                $(this).parents("ul.dropdown-menu").find('a').removeClass('active');
                $(this).addClass('active');
            }
            if ($(this).attr('href') === '#'||$(this).attr('href') === 'javascript:;') {
                e.preventDefault();
            }else{
                $(".dropdown").removeClass('open');
            }
            e.stopPropagation();
            return true;
        });
        $(".header > .nav > .dropdown-menu > li.open").each(function () {
            $(".sub-menu").hide();
            $(this).children(".sub-menu").show();
        });
    }

    function initToggleActiveState() {
        $(document).on("click", ".toggle-active", function (e) {
            $(this).toggleClass("active");
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initToggleSidebar() {
        $(document).on("click", ".toggle-sidebar", function (e) {
            e.preventDefault();
            e.stopPropagation();
            if (app.hasClass("small-menu")) {
                app.removeClass("small-menu");
                if (!$.browser.mobile && !checkBreakout() && $.fn.slimScroll) {
                    $(".no-touch .main-navigation").each(function () {
                        var data = $(this).data();
                        $(this).slimScroll(data);
                    });
                }
                jQuery.post(base+"/platform/login/layout", {p:"sidebar",v:false});
            } else if (!app.hasClass("small-menu")) {
                app.addClass("small-menu");
                if (!$.browser.mobile && $.fn.slimScroll) {
                    $(".no-touch .main-navigation").each(function () {
                        $(this).slimScroll({destroy: true}).removeAttr('style');
                    });
                }
                jQuery.post(base+"/platform/login/layout", {p:"sidebar",v:true});
            }
        });
    }

    function initToggleBoxed() {
        $(document).on("click", ".toggle-boxed", function (e) {
            if(app.hasClass("boxed")){
                app.removeClass("boxed");
                jQuery.post(base+"/platform/login/layout", {p:"boxed",v:false});
            }else{
                app.addClass("boxed");
                jQuery.post(base+"/platform/login/layout", {p:"boxed",v:true});
            }
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initToggleScroll() {
        $(document).on("click", ".toggle-scroll", function (e) {
            if(app.hasClass("fixed-scroll")){
                app.removeClass("fixed-scroll");
                jQuery.post(base+"/platform/login/layout", {p:"scroll",v:false});
            }else{
                app.addClass("fixed-scroll");
                jQuery.post(base+"/platform/login/layout", {p:"scroll",v:true});
            }
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initViewSwitcher() {
        $(document).on("click", ".view-options label", function (e) {
            if ($(this).data("view") === "grid") {
                $(".switcher").addClass("view-grid").removeClass("view-list");
            } else if ($(this).data("view") === "list") {
                $(".switcher").addClass("view-list").removeClass("view-grid");
            } else {
                return;
            }
            e.preventDefault();
            e.stopPropagation();
        });
    }

    function initFooterFix() {
        $("footer").each(function () {
            var footerHeight = $(this).outerHeight();
            if ($(this).prev().hasClass("content-wrap")) {
                $(this).prev().find(".wrapper").css("bottom", footerHeight);
            }
        });
    }

    function initSlider() {
        if ($.isFunction($.fn.slider)) {
            $(".sliders input").slider();
        }
    }

    function initSortableLists() {
        if ($.isFunction($.fn.sortable)) {
            $(".sortable").sortable();
            $(".handles").sortable({handle: "span"});
        }
    }

    function initIcheck() {
        if ($.isFunction($.fn.iCheck)) {
            $(".icheck").iCheck();
        }
    }

    function initTheme(){

        $(document).on("click", ".pg-toggle", function (e) {
            e.preventDefault();
            if ($(".playground").hasClass("opened")) {
                $(".playground").removeClass("opened");
            } else {
                $(".playground").addClass("opened");
            }
        });
        $(document).on("click", ".pg-close", function (e) {
            e.preventDefault();
            if ($(".playground").hasClass("opened")) {
                $(".playground").removeClass("opened");
            }
        });
        $(document).on("click", ".playground .font-options a", function (e) {
            e.preventDefault();
            var value = $(this).attr("href");
            $(".font-options").find("a").removeClass("active");
            $(this).addClass("active");
            $("#font").attr("href", value)
        });
        $(document).on("click", ".playground .header-options a", function (e) {
            e.preventDefault();
            var value = $(this).attr("id");
            if (value === "header-dark") {
                $(".header").addClass("header-dark")
            } else {
                $(".header").removeClass("header-dark")
            }
            $(".header-options").find("a").removeClass("active");
            $(this).addClass("active")
        });
        $(document).on("click", ".playground .color-options > a", function (e) {
            e.preventDefault();
            var value = $(this).attr("href");
            $(".color-options").find("a").removeClass("active");
            $(this).addClass("active");
            $("#skin").attr("href", value)
        });
    }
    return {
        checkBreakout: checkBreakout, init: function () {
            events();
            initAccordion();
            initAnimationAPI();
            initAnimateNumbers();
            initAnimateProgressBars();
            initLinkTransition();
            initBoxRefresh();
            initBoxRemove();
            initHeaderSearch();
            initBrowserFix();
            initMenuCollapse();
            initToggleActiveState();
            initToggleSidebar();
            initToggleScroll();
            initToggleBoxed();
            initViewSwitcher();
            initFooterFix();
            equalHeightWidgets();
            initDatePicker();
            initFuelUX();
            initChosen();
            initBoxCollapse();
            initPlacehoderFallback();
            initSlider();
            initSortableLists();
            initIcheck();
            initTheme();
        },
        initIcheck : initIcheck,//初始化复选框控件
        changeLang:function(lang){
            var url = window.location.href;
            if(url.indexOf("lang=")>0){
                url=url.replace("?lang="+GetQueryString("lang"),"").replace("&lang="+GetQueryString("lang"),"");
                console.log(url);
            } console.log(url);
            if(url.indexOf("?")>0){
                url+="&lang="+lang;
            }else {
                url+="?lang="+lang;
            }
            window.location.href=url;
        },
        changeTheme:function(obj){
            jQuery.post(base+"/platform/login/theme", {loginTheme:obj});
        },
        showLoadingbar : function(obj){//显示顶部进度条
            var clz = "waiting";
            if(!obj){
                clz += " full";
            }
            obj = obj || $("body");
            if($("#loadingbar").length<1){
                obj.prepend("<div id=\"loadingbar\"></div>");
                $("#loadingbar").addClass(clz).append($("<dt/><dd/>"));
                $("#loadingbar").width((50 + Math.random() * 30) + "%");
                var width = (50 + Math.random() * 30);
                var interval = setInterval(function(){
                    width = width + 10;
                    if(width<100){
                        $("#loadingbar").width(width + "%");
                    }else{
                        $("#loadingbar").width("101%");
                        clearInterval(interval);
                    }
                }, 1000);
                $("#loadingbar").attr("interval", interval);
            }
        },
        closeLoadingbar : function(obj){//关闭顶部进度条
            obj = obj || $("body");
            obj.find("#loadingbar").width("101%").delay(200).fadeOut(400, function() {
                var interval =  $(this).attr("interval");
                clearInterval(interval);
                $("#loadingbar").remove();
            });
        },
        toggleFilter : function(filter){//显示/隐藏筛选面板
            var filter = $(filter);
            filter.addClass('is-visible');

            filter.unbind("click");
            filter.bind("click", function(event){
                if( $(event.target).is('.cd-panel') || $(event.target).is('.cd-panel-close') ) {
                    filter.removeClass('is-visible');
                    event.preventDefault();
                }
            });
        }
    };
}();