
/**
 * 
 */

// 화면에 전체 테이블 정보 보여주기
function showTable(owner, tableName) {
	const info = {
					owner
					, tableName
				}
	
	$.ajax({
		url : 'oracle/info'
		, type : 'GET'
		, data : info
		, success : function(data){
			const tableName = data[0].tableName;
			const tableComment = data[0].tableComment == null ? '' : data[0].tableComment;
			
			let result = 
				`<table class="table table-bordered text-center">
					<thead>
						<tr>
							<td colspan="9">
								<h4><strong>DB 테이블 정보</string></h4>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row" colspan="2">테이블명</th>
							<td colspan="2">${tableName}</td>
							<th scope="row" colspan="2">엔티티명</th>
							<td colspan="3">${tableComment}</td>
						</tr>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">속성명</th>
							<th scope="col">컬럼명</th>
							<th scope="col">타입</th>
							<th scope="col">길이</th>
							<th scope="col">Not Null</th>
							<th scope="col">PK</th>
							<th scope="col">FK</th>
							<th scope="col">기본값</th>
						</tr>`;
			
				$.each(data, function(key, value){
					const num = value.num;
					const columnName = value.columnName;
					const dataType = value.dataType;
					const dataLength = value.dataLength == 0 ? '' : value.dataLength;
					const columnComment = value.columnComment == null ? '' : value.columnComment;
					const notNull = value.notNull == null ? '' : value.notNull;
					const pk = value.pk == null ? '' : value.pk;
					const fk = value.fk == null ? '' : value.fk;
					const dataDefault = value.dataDefault == null ? '' : value.dataDefault;
					
					result +=
						`<tr>
							<th scope="row">${num}</th>
							<td>${columnComment}</td>
							<td>${columnName}</td>
							<td>${dataType}</td>
							<td>${dataLength}</td>
							<td>${notNull}</td>
							<td>${pk}</td>
							<td>${fk}</td>
							<td>${dataDefault}</td>
						</tr>`;
				});
			
			result += 
				`	</tbody>
				</table>
				
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end mb-1">
					<P>전체 컬럼 모두 추출됩니다.</p>
				</div>
				
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end mb-3">
					<button type="button" id="btnCreateExcel" class="btn btn-outline-primary" onclick="excelDownload('${owner}', '${tableName}');">EXCEL</button>
					<button type="button" id="btnCreateCsv" class="btn btn-outline-success" onclick="csvDownload('${owner}', '${tableName}');">CSV</button>
					<button type="button" id="btnJson" class="btn btn-outline-warning" onclick="jsonDownload('${owner}', '${tableName}');">JSON</button>
					<button type="button" id="btnXml" class="btn btn-outline-danger" onclick="xmlDownload('${owner}', '${tableName}');">XML</button>
				</div>
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end">
					<button type="button" id="btnSelectTable" class="btn btn-primary" onclick="choiceTableInfo('${owner}', '${tableName}');">추출 정보 선택</button>
				</div>`;
					
			$('#showTable').html(result);
			window.scrollTo(0,0);
		}
	})
}

// 화면에 컬럼 정보 선택할 수 있는 테이블 보여주기
function choiceTableInfo(owner, tableName) {
	const info = {
					owner
					, tableName
				}
	
	$.ajax({
		url : 'oracle/info'
		, type : 'GET'
		, data : info
		, success : function(data){
			const tableName = data[0].tableName;
			const tableComment = data[0].tableComment == null ? '' : data[0].tableComment;
			
			let result = 
				`<table class="table table-bordered text-center">
					<thead>
						<tr>
							<td colspan="9">
								<h4 class="mb-3"><strong>DB 테이블 정보</strong></h4>
								<p>추출할 정보를 선택하세요</p>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row" colspan="2">테이블명</th>
							<td colspan="2">${tableName}</td>
							<th scope="row" colspan="2">엔티티명</th>
							<td colspan="3">${tableComment}</td>
						</tr>
						<tr>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="num" name="num" value="num" checked autocomplete="off">
								<label class="btn btn-outline-primary" for="num">번호</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="columnName" name="columnName" value="columnName" autocomplete="off">
								<label class="btn btn-outline-primary" for="columnName">속성명</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="columnComment" name="columnComment" value="columnComment" autocomplete="off">
								<label class="btn btn-outline-primary" for="columnComment">컬럼명</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="dataType" name="dataType" value="dataType" autocomplete="off">
								<label class="btn btn-outline-primary" for="dataType">타입</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="dataLength" name="dataLength" value="dataLength" autocomplete="off">
								<label class="btn btn-outline-primary" for="dataLength">길이</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="notNull" name="notNull" value="notNull" autocomplete="off">
								<label class="btn btn-outline-primary" for="notNull">Not Null</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="pk" name="pk" value="pk" autocomplete="off">
								<label class="btn btn-outline-primary" for="pk">PK</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="fk" name="fk" value="fk" autocomplete="off">
								<label class="btn btn-outline-primary" for="fk">FK</label>
							</th>
							<th scope="col">
								<input type="checkbox" class="btn-check" id="dataDefault" name="dataDefault" value="dataDefault" autocomplete="off"/>
								<label class="btn btn-outline-primary" for="dataDefault">기본값</label>
							</th>
						</tr>`;
			
				$.each(data, function(key, value){
					const num = value.num;
					const columnName = value.columnName;
					const dataType = value.dataType;
					const dataLength = value.dataLength == 0 ? '' : value.dataLength;
					const columnComment = value.columnComment == null ? '' : value.columnComment;
					const notNull = value.notNull == null ? '' : value.notNull;
					const pk = value.pk == null ? '' : value.pk;
					const fk = value.fk == null ? '' : value.fk;
					const dataDefault = value.dataDefault == null ? '' : value.dataDefault;
					
					result +=
						`<tr>
							<th scope="row">${num}</th>
							<td>${columnComment}</td>
							<td>${columnName}</td>
							<td>${dataType}</td>
							<td>${dataLength}</td>
							<td>${notNull}</td>
							<td>${pk}</td>
							<td>${fk}</td>
							<td>${dataDefault}</td>
						</tr>`;
				});
			
			result += 
				`	</tbody>
				</table>
				
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end mb-1">
					<P>선택한 컬럼만 추출됩니다.</p>
				</div>
				
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end mb-3">
					<button type="button" id="btnExcel" class="btn btn-outline-primary" onclick="choiceExcelDownload('${owner}', '${tableName}');">EXCEL</button>
					<button type="button" id="btnCsv" class="btn btn-outline-success" onclick="choiceCsvDownload('${owner}', '${tableName}');">CSV</button>
					<button type="button" id="btnJson" class="btn btn-outline-warning" onclick="choiceJsonDownload('${owner}', '${tableName}');">JSON</button>
					<button type="button" id="btnXml" class="btn btn-outline-danger" onclick="choiceXmlDownload('${owner}', '${tableName}');">XML</button>
				</div>
				
				<div class="d-grid gap-3 d-sm-flex justify-content-sm-end">
					<button type="button" id="btnSelectTable" class="btn btn-primary" onclick="showTable('${owner}', '${tableName}');">전체 정보 추출</button>
				</div>`;
					
			$('#showTable').html(result);
			window.scrollTo(0,0);
		}
	})
}