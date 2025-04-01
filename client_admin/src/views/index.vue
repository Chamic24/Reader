<template>
	<div class="page_root" id="root_index">
		<div class="warp">
			<div class="container-fluid">
				<el-row>
					<el-col :span="4">
						<mm_label bg_color="bg_purple" icon="el-icon-user-solid" :url="url_user_count" unit="人"
								  title="用户数量"></mm_label>
					</el-col>
<!--					<el-col :span="4">-->
<!--						<mm_label bg_color="bg_green" icon="el-icon-view" :url="url_article_hits" unit="次"-->
<!--								  title="文章浏览量"></mm_label>-->
<!--					</el-col>-->
				</el-row>

				<el-row>
						<el-col v-if="user_group == '管理员' || $check_figure('/registered_users/table')" :span="8">
						<div class="card chart">
																														<pieChart v-if="list_registered_users.length" id="list_registered_users" :list="list_registered_users" :title="'注册用户统计'"></pieChart>
							<div v-if="!list_registered_users.length">注册用户没有符合条件的数据</div>
															</div>
					</el-col>
													<el-col v-if="user_group == '管理员' || $check_figure('/purchase_vip/table')" :span="8">
						<div class="card chart">
									<newBarChart v-if="bar_obj_purchase_vip.values.length > 0" id="bar_obj_purchase_vip" :vm="bar_obj_purchase_vip" :title="'购买VIP统计'">
							</newBarChart>
							<div v-if="!bar_obj_purchase_vip.values.length">购买VIP没有符合条件的数据</div>
								</div>
					</el-col>
					</el-row>


			</div>
		</div>
	</div>
</template>
<script>
	import mixin from "@/mixins/page.js";
	import pieChart from "@/components/charts/pie_chart";
	import barChart from "@/components/charts/bar_chart";
	import newBarChart from "@/components/charts/new_bar_chart";
	import lineChart from "@/components/charts/line_chart";
	import newLineChart from "@/components/charts/new_line_chart";
	import mm_label from "@/components/mm_label.vue";
	export default {
		mixins: [mixin],
		name: "Home",
		components: {
			pieChart,
			barChart,
			newBarChart,
			lineChart,
			newLineChart,
			mm_label
		},
		data() {
			return {
				activeName: "third",
					list_registered_users: [],
																		bar_obj_purchase_vip: {
					names:[],
					xAxis: [],
					values:[]
				},
					url_user_count: "~/api/user/count?",
				url_article_hits: "~/api/article/sum?field=hits",
			};
		},
		created() {
				// 执行注册用户数据获取
			this.get_list_registered_users();
											// 执行购买VIP数据获取
			this.get_list_purchase_vip();
			},
		mounted() {},
		methods: {
			async get_nickname(list,flag){
				if (flag) {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i],
								null,
								(json) => {
									if (json.result) {
										list[i] = json.result.obj.nickname;
									}
								});
					}
				}else {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i].name,
								null,
								(json) => {
									if (json.result) {
										list[i].name = json.result.obj.nickname;
									}
								});
					}
				}
			},
																			// 获取注册用户统计图数据
			get_list_registered_users() {
				let data = {};
								let flag = false;
												this.$get("~/api/registered_users/list_group?groupby=gender", data, (json) => {
					if (json.result) {
						var list = json.result.list;
						this.list_registered_users = list.map((o) => {
							return {
												name: o[1],
												value: o[0]
							};
						});
						if (flag){
							this.get_nickname(this.list_registered_users,false);
						}
					}
				});
			},
																						// 获取购买VIP统计柱状图
			async get_list_purchase_vip() {
				let name_list = [];
				let query_str = "";
																	let group_by_value = "book_name";
								let flag = false;
												let date_flag = "其他"
																																						name_list.push("VIP价格");
				query_str = query_str+"vip_price"+","
																																	this.bar_obj_purchase_vip.names = name_list
				query_str = query_str.substr(0,query_str.length-1);
				let data = {};
						let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
								let sqlwhere = "(";
																																																											if (user_group=="注册用户"){
						sqlwhere+= "user_number = " + user_id + " or ";
					}
																																if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						data.sqlwhere = sqlwhere;
					}
							}
						await this.$get(
						"~/api/purchase_vip/bar_group?field="+query_str+"&groupby="+group_by_value,
						data,
						(json) => {
							if (json.result) {
								let xAxis = [];
								let values = [];
								json.result.list.map((o) => {
									if (date_flag === "日期") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd"));
									}else if (date_flag === "时间") {
										xAxis.push(this.$toTime(o[0] ,"hh:mm:ss"));
									}else if (date_flag === "日长") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd hh:mm:ss"));
									}else {
										xAxis.push(o[0]);
									}
									values.push(o.splice(1))
								});
								this.bar_obj_purchase_vip.xAxis = xAxis;
								this.bar_obj_purchase_vip.values = values;
							}
							if (flag){
								this.get_nickname(this.bar_obj_purchase_vip.xAxis,true);
							}
						});
			},
	
		},
		computed:{
			recognitionHeight(){
				return "830px"
			},
			recognitionUrl(){
				return "https://www.faceplusplus.com.cn/${model.filter.recognitionType}/"
			}
		}
	};
</script>

<style scoped="scoped">
	.chart {
		display: block;
		width: 100%;
		height: 400px;
		padding: 1rem;
		position: relative;
	}

	.el-col {
		padding: 0.5rem;
	}

	.card {
		overflow: hidden;
	}

	.iframe_box ,.iframe_box_change{
		width: 100%;
		height: 1180px;
		position: relative;
		margin-top: 25px;
	}
	.iframe_box_change{
		height: 580px;
		padding-top: 50px;
	}
	.iframe_box	.iframe_box_content, .iframe_box_change .iframe_box_content{
		width: 100%;
		height: 100%;
	}
	.iframe_box_top{
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100px;
		font-size: 25px;
		line-height: 100px;
		background: #fff;
		z-index: 99999999;
		padding-left: 50px;
	}
	#iframe_box_face div::before {
		content: '';
		width: 100px;
		position: absolute;
		top: 154px;
		right: 129px;
		z-index: 999;
		height: 20px;
		background-color: #FFFFFF;
	}

	#iframe_box_face>h1 {
		margin-top: 100px;
		margin-bottom: 20px;
	}
</style>
