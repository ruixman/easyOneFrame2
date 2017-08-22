$(function () {
    //var valdationRegex = {
    //    number: /^\d*$/i,
    //    decimal: /^\d*\.\d/i,
    //    phone: /(^1[3|4|5|8][0-9]\d{8}$)|(^17[0|6|7|8]\d{8}$)/i,
    //    idNo: /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/i,
    //    english: /^[a-zA-Z]$/i,
    //    trainNo: /^[0-9a-zA-Z]$/i
    //};

    //$('input[validation]').change(function () {
    //    var $inputGroup = $(this).closest('.input-group');
    //    if ($inputGroup.hasClass('has-error')) {
    //        $inputGroup.removeClass('has-error').next('.help-block-error').remove();
    //    }
    //});

    $('.submit').click(function () {
        //$('.has-error').removeClass('has-error');
        //$('.help-block-error').remove();
        //var $input = $('input[validation]');

        //var formValidation = true;
        //$input.each(function () {
        //    var $this = $(this);
        //    var inputVal = $(this).val();
        //    var $inputGroup = $(this).closest('.input-group');
        //    var $formGroup = $(this).closest('.form-group');
        //    var label = $formGroup.find('label').text();

        //    var validataion = $this.attr('validation');
        //    var validataionList = validataion.split(',');

        //    var result = true;
        //    $.each(validataionList, function () {
        //        var thisVal = this, validate;

        //        if (thisVal == 'required') {
        //            if ($.trim(inputVal) == '') {
        //                validate = 'required';
        //            }
        //        }
        //        else if (thisVal == 'number') {
        //            if (!valdationRegex.number.test(inputVal)) {
        //                validate = 'number';
        //            }
        //        }
        //        else if (thisVal == 'phone') {
        //            if (!valdationRegex.phone.test(inputVal)) {
        //                validate = 'phone';
        //            }
        //        }
        //        else if (thisVal == 'decimal') {
        //            if (!valdationRegex.decimal.test(inputVal)) {
        //                validate = 'decimal';
        //            }
        //        }
        //        else if (thisVal == 'idNo') {
        //            if (!valdationRegex.idNo.test(inputVal)) {
        //                validate = 'idNo';
        //            }
        //        }
        //        else if (thisVal == 'english') {
        //            if (!valdationRegex.english.test(inputVal)) {
        //                validate = 'english';
        //            }
        //        }
        //        else if (thisVal == 'trainNo') {
        //            if (!valdationRegex.trainNo.test(inputVal)) {
        //                validate = 'trainNo';
        //            }
        //        }

        //        if (validate && result) {
        //            result = false;
        //            if (validate == 'required') {
        //                $inputGroup.addClass('has-error');
        //                $inputGroup.after('<span class="help-block help-block-error">请输入' + label + '</span>');
        //            }
        //            else {
        //                $inputGroup.addClass('has-error');
        //                $inputGroup.after('<span class="help-block help-block-error">请输入正确的' + label + '</span>');
        //            }
        //        }
        //    });


        //    if (result) {
        //        $inputGroup.removeClass('has-error');
        //        $inputGroup.next('.help-block-error').remove();
        //    }
        //    else {
        //        formValidation = result;
        //    }

        //});

        if (formValidation) {
            var postData = {};
            $('form input[name]').each(function () {
                postData[this.name] = $(this).val();
            });

            var $form = $(this).closest('form');
            if ($form.attr('post-url')) {
                $.post($form.attr('post-url'), postData, function (data) {
                    if ($form.attr('return-url')) {
                        window.location.href = $form.attr('return-url');
                    }
                }, "json").error(function () {
                    alert('网络异常，请稍后重试');
                });
            }
        }

        return false;
    });


    //表单初始化
    var $form = $('.form');
    if ($form.length > 0) {
        $form.each(function () {
            var $this = $(this);
            if ($this.attr('init-url')) {
                var param = { id: window.location.search };
                $.post($this.attr('init-url'), param, function (data) {
                    for (var property in data.data) {
                        $('[name=' + property + ']').val(data.data[property]);
                    }
                }, "json").error(function () {
                    alert('网络异常，请稍后重试');
                });
            }
        });
    }

    window.appGloble = {
        dataTableSettings: {
            info: false,
            searching: false,
            ordering: false,
            bLengthChange: false,
            paging: true,
            processing: true,
            serverSide: true,
            pagingType: "full_numbers",
            pageLength: 10,
            fnServerParams: function (aoData) {
                aoData.pageIndex = $(this).DataTable().page() + 1;
            },
            ajax: {
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                data: function (postData) {
                    if (window.appGloble.dataTableSettings.queryData) {
                        $.extend(postData, window.appGloble.dataTableSettings.queryData);
                    }

                    return JSON.stringify(postData)
                }
            },
            language: {
                emptyTable: "无相关数据",
                zeroRecords: "无相关数据",
                processing: "",
                paginate: {
                    first: "首页",
                    last: "末页",
                    previous: "上一页",
                    next: "下一页"
                }
            }
        }
    }
});