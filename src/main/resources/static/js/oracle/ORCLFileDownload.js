/**
 * 
 */

// 테이블 전체 컬럼을 엑셀파일로 추출
function excelDownload(owner, tableName) {
	const info = {
					owner
					, tableName
				}

	$.ajax({
		url : 'oracle/excelDownload'
		, type : 'GET'
		, data : info
		, success : function(data){
			alert(data + ' 파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
		}
		, error : function(request) {
			if(request.status == '500'){
				location.replace('error');
			}
		}
	})
}

//테이블 선택 컬럼을 엑셀파일로 추출
function choiceExcelDownload(owner, tableName) {
	const choiceInfoName = new Array();

	$('input:checked').each(function(i){
		const name = $(this).attr('name');
		
		choiceInfoName.push(name);
	})
	
	$.ajax({
		url : 'oracle/choiceExcelDownload/' + owner + '/' + tableName
		, type : 'GET'
		, traditional : true
		, data : {'choiceInfoName' : choiceInfoName}
		, success : function(data) {
			alert(data + ' 파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
			showTable(owner, tableName);
		}
		, error : function(request) {
			if(request.status == '500'){
				location.replace('error');
			}
		}
	})
}

// 테이블 전체 컬럼을 CSV파일로 추출
function csvDownload(owner, tableName) {
	const info = {
					owner
					, tableName
				};
	
	$.ajax({
		url : 'oracle/csvDownload'
		, type : 'GET'
		, data : info
		, success : function(data) {
			alert(data + ' CSV파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
		}
		, error : function(request) {
			if(request.status == '500'){
				location.replace('error');
			}
		}
	});
}

// 테이블 선택 컬럼을 CSV파일로 추출
function choiceCsvDownload(owner, tableName) {
	const choiceInfoName = new Array();
	
	$('input:checked').each(function(i){
		const name = $(this).attr('name');
		
		choiceInfoName.push(name);
	});
	
	$.ajax({
		url : 'oracle/choiceCsvDownload/' + owner + '/' + tableName
		, type : 'GET'
		, traditional : true
		, data : {'choiceInfoName' : choiceInfoName}
		, success : function(data) {
			alert(data + ' CSV파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
			showTable(owner, tableName);
		}
		, error : function(request) {
			if(request.status == '500'){
				location.replace('error');
			}
		}
	});
}

// 테이블 전체 컬럼을 JSON파일로 추출
function jsonDownload(owner, tableName) {
	const info = {
					owner
					, tableName
				};
	
	$.ajax({
		url : 'oracle/jsonDownload'
		, type : 'GET'
		, data : info
		, success : function(data) {
			alert(data + ' CSV파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
		}
		, error : function(request) {
			if(request.status == '500'){
				location.replace('error');
			}
		}
	});
}

//테이블 선택 컬럼을 JSON파일로 추출
function choiceJsonDownload(owner, tableName) {
	const choiceInfoName = new Array();
	
	$('input:checked').each(function(i){
		const name = $(this).attr('name');
		
		choiceInfoName.push(name);
	});
	
	$.ajax({
		url : 'oracle/choiceJsonDownload/' + owner + '/' + tableName
		, type : 'GET'
		, traditional : true
		, data : {'choiceInfoName' : choiceInfoName}
		, success : function(data) {
			alert(data + ' JSON파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
			showTable(owner, tableName);
		}
		, error : function(request) {
			if(request.status = '500') {
				location.replace('error');
			}
		}
	});
}

//테이블 전체 컬럼 XML 추출
function xmlDownload(owner, tableName) {
	const info = {
					owner
					, tableName
				};
	
	$.ajax({
		url : 'oracle/xmlDownload'
		, type : 'GET'
		, data : info
		, success : function(data) {
			alert(data + ' XML파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
		}
		, error : function(request) {
			if(request.status = '500') {
				location.replace('error');
			}
		}
	});
}

// 테이블 선택 컬럼 XML 추출
function choiceXmlDownload(owner, tableName) {
	const choiceInfoName = new Array();
	
	$('input:checked').each(function(i) {
		const name = $(this).attr('name');
		
		choiceInfoName.push(name);
	})
	
	$.ajax({
		url : 'oracle/choiceXmlDownload/' + owner + '/' + tableName
		, type : 'GET'
		, traditional : true
		, data : {'choiceInfoName' : choiceInfoName}
		, success : function(data) {
			alert(data + ' XML파일이 성공적으로 생성되었습니다.\n다운로드 폴더를 확인해주세요.');
			showTable(owner, tableName);
		}
		, error : function(request) {
			if(request.status = '500') {
				location.replace('error');
			}
		}
	});
}
