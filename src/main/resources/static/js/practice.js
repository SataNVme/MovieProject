function getSearchList() {
		$.ajax({
			type : 'GET',
			url : "/getSearchList",
			data : $("form[name=search-form]").serialize(),
			success : function(result) {
					// 테이블 초기화
					$("#searchTable" > 'tbody').empty();
					if(result.length >= 1) {
						result.foreach(function(item) {
							str='<tr>'
							str += "<td>" + item.movie_koficCd + "</td>";
							str += "<td><a href= '/search/searchDetail?movie_koficCd=" + item.movie_koficCd +"'>" + item.movie_Nm + "</a></td>";
							str += "<td>" + item.movie_dirNm + "</td>";
							str += "<td>" + item.movie_actNm + "</td>";
							str += "</tr>"
							$('#searchTable').append(str);
						});
					}
			}
		});
}