/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{

//加入的内容

// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.language = 'zh-cn'; // 配置语言
//
//    config.uiColor = '#fff'; // 背景颜色
//
      config.width = '800px'; // 宽度

      config.height = '300px'; // 高度
//
//    config.skin = 'office2003';// 界面v2,kama,office2003
//
//    config.toolbar = 'Full';// 工具栏风格Full,Basic
//    
//    config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;' +
//    '隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;

	//  config.htmlEncodeOutput = true;
	//config.startupOutlineBlocks = false; 


/*** 文件上传功能的配置-----------------------
	 */
	config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html'; 
    config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images';
    config.filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?type=Flash';
    config.filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
	//---------------------------文件上传功能的配置结束--------
};
