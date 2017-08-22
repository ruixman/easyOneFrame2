/**
 * jQuery Validation Plugin 1.8.0
 *
 * http://bassistance.de/jquery-plugins/jquery-plugin-validation/
 * http://docs.jquery.com/Plugins/Validation
 *
 * Copyright (c) 2006 - 2011 Jörn Zaefferer
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
(function(){function a(b){return b.replace(/<.[^<>]*?>/g," ").replace(/&nbsp;|&#160;/gi," ").replace(/[0-9.(),;:!?%#$'"_+=\/-]*/g,"")}jQuery.validator.addMethod("maxWords",function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length<d},jQuery.validator.format("Please enter {0} words or less."));jQuery.validator.addMethod("minWords",function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length>=d},jQuery.validator.format("Please enter at least {0} words."));jQuery.validator.addMethod("rangeWords",
function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length>=d[0]&&b.match(/bw+b/g).length<d[1]},jQuery.validator.format("Please enter between {0} and {1} words."))})();
jQuery.validator.addMethod("letterswithbasicpunc",function(a,b){return this.optional(b)||/^[a-z-.,()'\"\s]+$/i.test(a)},"Letters or punctuation only please");
jQuery.validator.addMethod("alphanumeric",function(a,b){return this.optional(b)||/^\w+$/i.test(a)},"Letters, numbers, spaces or underscores only please");
jQuery.validator.addMethod("lettersonly",function(a,b){return this.optional(b)||/^[a-z]+$/i.test(a)},"Letters only please");
jQuery.validator.addMethod("nowhitespace",function(a,b){return this.optional(b)||/^\S+$/i.test(a)},"No white space please");
jQuery.validator.addMethod("ziprange",function(a,b){return this.optional(b)||/^90[2-5]\d\{2}-\d{4}$/.test(a)},"Your ZIP-code must be in the range 902xx-xxxx to 905-xx-xxxx");
jQuery.validator.addMethod("integer",function(a,b){return this.optional(b)||/^-?\d+$/.test(a)},"请输入数字");
jQuery.validator.addMethod("vinUS",function(a){if(a.length!=17)return false;var b,c,d,f,e,g=["A","B","C","D","E","F","G","H","J","K","L","M","N","P","R","S","T","U","V","W","X","Y","Z"],i=[1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9],j=[8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2],h=0;for(b=0;b<17;b++){f=j[b];d=a.slice(b,b+1);if(b==8)e=d;if(isNaN(d))for(c=0;c<g.length;c++){if(d.toUpperCase()===g[c]){d=i[c];d*=f;if(isNaN(e)&&c==8)e=g[c];break}}else d*=f;h+=d}a=h%11;if(a==10)a="X";if(a==e)return true;return false},
"The specified vehicle identification number (VIN) is invalid.");jQuery.validator.addMethod("dateITA",function(a,b){var c=false;if(/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(a)){var d=a.split("/");c=parseInt(d[0],10);var f=parseInt(d[1],10);d=parseInt(d[2],10);var e=new Date(d,f-1,c);c=e.getFullYear()==d&&e.getMonth()==f-1&&e.getDate()==c?true:false}else c=false;return this.optional(b)||c},"Please enter a correct date");
jQuery.validator.addMethod("dateNL",function(a,b){return this.optional(b)||/^\d\d?[\.\/-]\d\d?[\.\/-]\d\d\d?\d?$/.test(a)},"Vul hier een geldige datum in.");
jQuery.validator.addMethod("time",function(a,b){return this.optional(b)||/^([01][0-9])|(2[0123]):([0-5])([0-9])$/.test(a)},"Please enter a valid time, between 00:00 and 23:59");
jQuery.validator.addMethod("phoneUS",function(a,b){a=a.replace(/\s+/g,"");return this.optional(b)||a.length>9&&a.match(/^(1-?)?(\([2-9]\d{2}\)|[2-9]\d{2})-?[2-9]\d{2}-?\d{4}$/)},"Please specify a valid phone number");
jQuery.validator.addMethod("phoneUK",function(a,b){return this.optional(b)||a.length>9&&a.match(/^(\(?(0|\+44)[1-9]{1}\d{1,4}?\)?\s?\d{3,4}\s?\d{3,4})$/)},"Please specify a valid phone number");
jQuery.validator.addMethod("mobileUK",function(a,b){return this.optional(b)||a.length>9&&a.match(/^((0|\+44)7(5|6|7|8|9){1}\d{2}\s?\d{6})$/)},"Please specify a valid mobile number");
jQuery.validator.addMethod("strippedminlength",function(a,b,c){return jQuery(a).text().length>=c},jQuery.validator.format("Please enter at least {0} characters"));
jQuery.validator.addMethod("email2",function(a,b){return this.optional(b)||/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(a)},jQuery.validator.messages.email);
jQuery.validator.addMethod("url2",function(a,b){return this.optional(b)||/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(a)},
jQuery.validator.messages.url);
jQuery.validator.addMethod("creditcardtypes",function(a,b,c){if(/[^0-9-]+/.test(a))return false;a=a.replace(/\D/g,"");b=0;if(c.mastercard)b|=1;if(c.visa)b|=2;if(c.amex)b|=4;if(c.dinersclub)b|=8;if(c.enroute)b|=16;if(c.discover)b|=32;if(c.jcb)b|=64;if(c.unknown)b|=128;if(c.all)b=255;if(b&1&&/^(51|52|53|54|55)/.test(a))return a.length==16;if(b&2&&/^(4)/.test(a))return a.length==16;if(b&4&&/^(34|37)/.test(a))return a.length==15;if(b&8&&/^(300|301|302|303|304|305|36|38)/.test(a))return a.length==14;if(b&
16&&/^(2014|2149)/.test(a))return a.length==15;if(b&32&&/^(6011)/.test(a))return a.length==16;if(b&64&&/^(3)/.test(a))return a.length==16;if(b&64&&/^(2131|1800)/.test(a))return a.length==15;if(b&128)return true;return false},"Please enter a valid credit card number.");
jQuery.validator.addMethod("ipv4",function(a,b){return this.optional(b)||/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/i.test(a)},"Please enter a valid IP v4 address.");
jQuery.validator.addMethod("ipv6",function(a,b){return this.optional(b)||/^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}:([0-9A-Fa-f]{1,4}:)?[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){4}:([0-9A-Fa-f]{1,4}:){0,2}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){3}:([0-9A-Fa-f]{1,4}:){0,3}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){2}:([0-9A-Fa-f]{1,4}:){0,4}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(([0-9A-Fa-f]{1,4}:){0,5}:((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(::([0-9A-Fa-f]{1,4}:){0,5}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|([0-9A-Fa-f]{1,4}::([0-9A-Fa-f]{1,4}:){0,5}[0-9A-Fa-f]{1,4})|(::([0-9A-Fa-f]{1,4}:){0,6}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:))$/i.test(a)},"Please enter a valid IP v6 address.");
jQuery.validator.addMethod("alphanumeric", function(value, element){return this.optional(element) || /^\w+$/i.test(value);},"Letters, numbers, spaces or underscores only please");

jQuery.validator.addMethod("requiredTo",function(value, element, param){var requiredTo = $(param).val();if(requiredTo != "") {return value != "";} else {return true;}}, "此内容为必填项,请输入");
jQuery.validator.addMethod("requiredOne", function(value, element, param) {var requiredOne = $(param).val();if(requiredOne == "") {return value != "";} else {return true;};}, $.validator.format("两项必须填写一项"));
jQuery.validator.addMethod("notEqual", function(value, element, param) {return value != param;}, $.validator.format("输入值不允许为{0}"));
jQuery.validator.addMethod("positive", function(value, element) {return this.optional(element) || value > 0;}, "只允许输入整数");

// 判断整数value是否等于0 
jQuery.validator.addMethod("isIntEqZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value==0;       
}, "整数必须为0"); 
  
// 判断整数value是否大于0
jQuery.validator.addMethod("isIntGtZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value>0;       
}, "整数必须大于0"); 
  
// 判断整数value是否大于或等于0
jQuery.validator.addMethod("isIntGteZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value>=0;       
}, "整数必须大于或等于0");   

// 判断整数value是否不等于0 
jQuery.validator.addMethod("isIntNEqZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value!=0;       
}, "整数必须不等于0");  

// 判断整数value是否小于0 
jQuery.validator.addMethod("isIntLtZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value<0;       
}, "整数必须小于0");  

// 判断整数value是否小于或等于0 
jQuery.validator.addMethod("isIntLteZero", function(value, element) { 
     value=parseInt(value);      
     return this.optional(element) || value<=0;       
}, "整数必须小于或等于0");  

// 判断浮点数value是否等于0 
jQuery.validator.addMethod("isFloatEqZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value==0;       
}, "浮点数必须为0"); 
  
// 判断浮点数value是否大于0
jQuery.validator.addMethod("isFloatGtZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value>0;       
}, "浮点数必须大于0"); 
  
// 判断浮点数value是否大于或等于0
jQuery.validator.addMethod("isFloatGteZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value>=0;       
}, "浮点数必须大于或等于0");   

// 判断浮点数value是否不等于0 
jQuery.validator.addMethod("isFloatNEqZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value!=0;       
}, "浮点数必须不等于0");  

// 判断浮点数value是否小于0 
jQuery.validator.addMethod("isFloatLtZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value<0;       
}, "浮点数必须小于0");  

// 判断浮点数value是否小于或等于0 
jQuery.validator.addMethod("isFloatLteZero", function(value, element) { 
     value=parseFloat(value);      
     return this.optional(element) || value<=0;       
}, "浮点数必须小于或等于0");  

// 判断浮点型  
jQuery.validator.addMethod("isFloat", function(value, element) {       
     return this.optional(element) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
}, "只能包含数字、小数点等字符"); 
 
// 匹配integer
jQuery.validator.addMethod("isInteger", function(value, element) {       
     return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value)>=0);       
}, "匹配integer");  
 
// 判断数值类型，包括整数和浮点数
jQuery.validator.addMethod("isNumber", function(value, element) {       
     return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
}, "匹配数值类型，包括整数和浮点数");  

// 只能输入[0-9]数字
jQuery.validator.addMethod("isDigits", function(value, element) {       
     return this.optional(element) || /^\d+$/.test(value);       
}, "只能输入0-9数字");  

// 判断中文字符 
jQuery.validator.addMethod("isChinese", function(value, element) {       
     return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
}, "只能包含中文字符。");   

// 判断英文字符 
jQuery.validator.addMethod("isEnglish", function(value, element) {       
     return this.optional(element) || /^[A-Za-z]+$/.test(value);       
}, "只能包含英文字符。");   

 // 手机号码验证    
jQuery.validator.addMethod("isMobile", function(value, element) {    
  var length = value.length;    
  return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));    
}, "请正确填写您的手机号码。");

// 电话号码验证    
jQuery.validator.addMethod("isPhone", function(value, element) {    
  var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
  return this.optional(element) || (tel.test(value));    
}, "请正确填写您的电话号码。");

// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isTel", function(value,element) {   
    var length = value.length;   
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;   
    var tel = /^(\d{3,4}-?)?\d{7,9}$/g;       
    return this.optional(element) || tel.test(value) || (length==11 && mobile.test(value));   
}, "请正确填写您的联系方式"); 

 // 匹配qq      
jQuery.validator.addMethod("isQq", function(value, element) {       
     return this.optional(element) || /^[1-9]\d{4,12}$/;       
}, "匹配QQ");   

 // 邮政编码验证    
jQuery.validator.addMethod("isZipCode", function(value, element) {    
  var zip = /^[0-9]{6}$/;    
  return this.optional(element) || (zip.test(value));    
}, "请正确填写您的邮政编码。");  

// 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。      
jQuery.validator.addMethod("isPwd", function(value, element) {       
     return this.optional(element) || /^[a-zA-Z]\\w{6,12}$/.test(value);       
}, "以字母开头，长度在6-12之间，只能包含字符、数字和下划线。");

jQuery.validator.addMethod("username", function(value, element) {       
    return this.optional(element) || /^[a-zA-Z]\\w{5,10}$/.test(value);       
}, "以字母开头，长度在5-10之间，只能包含字符、数字和下划线。");
// 身份证号码验证
jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
  //var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;   
  return this.optional(element) || isIdCardNo(value);    
}, "请输入正确的身份证号码。"); 

// IP地址验证   
jQuery.validator.addMethod("ip", function(value, element) {    
  return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
}, "请填写正确的IP地址。");

//jQuery.validator.addMethod("username",function(value, element){return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);},"只允许包含中文、英文、数字和下划线");
// 字符验证，只能包含中文、英文、数字、下划线等字符。    
jQuery.validator.addMethod("stringCheck", function(value, element) {       
     return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5-_]+$/.test(value);       
}, "只能包含中文、英文、数字、下划线等字符");   

// 匹配english  
jQuery.validator.addMethod("isEnglish", function(value, element) {       
     return this.optional(element) || /^[A-Za-z]+$/.test(value);       
}, "匹配english");   

// 匹配汉字  
jQuery.validator.addMethod("isChinese", function(value, element) {       
     return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);       
}, "匹配汉字");   

// 匹配中文(包括汉字和字符) 
jQuery.validator.addMethod("isChineseChar", function(value, element) {       
     return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
}, "匹配中文(包括汉字和字符) "); 
  
// 判断是否为合法字符(a-zA-Z0-9-_)
jQuery.validator.addMethod("isRightfulString", function(value, element) {       
     return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);       
}, "判断是否为合法字符(a-zA-Z0-9-_)");   

// 判断是否包含中英文特殊字符，除英文"-_"字符外
jQuery.validator.addMethod("isContainsSpecialChar", function(value, element) {  
     var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\.)(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);   
     return this.optional(element) || !reg.test(value);       
}, "含有中英文特殊字符"); 


jQuery.validator.addMethod("positiveInteger",function(value, element){return this.optional(element) || /^[1-9]\d*$/.test(value);}, "只允许输入正整数");
jQuery.validator.addMethod("imageFile",function(value, element){return this.optional(element) || /(.jpg|.jpeg|.gif|.bmp|.png)$/i.test(value);}, "图片文件格式错误");
jQuery.validator.addMethod("isIdCardNo", function (value, element) {
    return this.optional(element) || isIdCardNo(value);
}, "请正确输入您的身份证号码");
function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }
    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}
function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}

function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}