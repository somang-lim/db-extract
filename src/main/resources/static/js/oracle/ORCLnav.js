/**
 * 
 */

$(function(){

	ownerList();
	
})

// 네비바에 스키마리스트 보여주기
function ownerList() {
	$.ajax({
		url : 'oracle/ownerList'
		, type : 'GET'
		, success : function(data){
			let result = 
				`<div class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
					<span class="fs-5 fw-semibold">DB SCHEMA INFO</span>
				</div>`;
			$.each(data, function(key, value){
				const own = value.owner;
				result += 
					`<div>
						<input type="hidden" id="${own}" value="${own}">
						<button class="btn align-items-center rounded" value="${own}" onclick="tableList(${own});">${own}</button>
					</div>`;
			});
			
			$('#navList').html(result);
		}
	})
}

// 네비바에 테이블리스트 보여주기
function tableList(own) {
	const owner = own.value;
	
	$.ajax({
		url : 'oracle/tableList'
		, type : 'GET'
		, data : {owner}
		, success : function(data){
			let result =
				`<button type="button" onclick="backspace();" class="btn btn-sm btn-outline-secondary">&lt; 뒤로가기</button>
				<div class="d-flex align-items-center pb-3 my-3 link-dark text-decoration-none border-bottom">
					<span class="fs-5 fw-semibold">${owner}</span>
				</div>`;
			$.each(data, function(key, value){
				const owner = value.owner;
				const tableName = value.tableName;
				
				result += 
					`<div>
						<input type="hidden" id="${owner}" value="${owner}">
						<input type="hidden" id="${tableName}" value="${tableName}">
						<button class="btn align-items-center rounded" value="${tableName}" onclick="showTable('${owner}', '${tableName}');">${tableName}</button>
					</div>`;
			});
			
			$('#navList').html(result);
		}
	})
	
}

function backspace() {
	ownerList();
}