<template>
	<view class="page_read_settings diy_list diy_list_page div_list_tml" id="read_settings_list">
		<!-- 筛选模块(开始) -->
		<view>
			<view class="container">
				<view>
					<view>
						<view class="">
							<!-- 搜索栏 -->
														<uni-search-bar placeholder="搜索图书名称" @confirm="search" @cancel="cancel" cancelText="取消"
											@input="input($event, 'book_name')">
								<uni-icons slot="searchIcon" color="#999999" size="18" type="home" />
							</uni-search-bar>
																					<uni-search-bar placeholder="搜索章节" @confirm="search" @cancel="cancel" cancelText="取消"
											@input="input($event, 'chapter')">
								<uni-icons slot="searchIcon" color="#999999" size="18" type="home" />
							</uni-search-bar>
																			<!-- /搜索栏 -->
						</view>
					</view>
				</view>

				<view>
					<view>
						<view class="tab_view">
							<!-- 筛选栏 -->
																								<!-- /筛选栏 -->
						</view>
					</view>
				</view>

				<view>
					<view>
						<view class="sort_view">
							<!-- 排序 -->
							<view class="list_orderby">
								<bar_orderby :text="o.name" v-model:direction="o.direction" :direction.sync="o.direction"
											 v-for="(o,i) in list_orderby" :key="i" @handle="handleOrderby">
								</bar_orderby>
							</view>
							<!-- /排序 -->
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 筛选模块(结束) -->
		<!-- 列表 -->
			<view class="warp" >
			<view class="container">
				<view v-for="(o,i) in list" class="row box_style">
							<view class="col" v-if="0 && $check_field('get','book_number')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>图书编号</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["book_number"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="1 && $check_field('get','book_name')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>图书名称</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["book_name"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="1 && $check_field('get','book_category')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>图书类别</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["book_category"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="1 && $check_field('get','author')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>作者</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["author"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="1 && $check_field('get','chapter')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>章节</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["chapter"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','user_number')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>用户编号</span>
							</view>
										<view class="diy_field diy_uid">
								<span>
									{{ get_user_user_number(o['user_number']) }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','reading_background')">
						<view class="view">
							<view class="diy_title" v-if=" false">
								<span>阅读背景</span>
							</view>
										<view class="diy_field diy_img">
								<img :src="$fullUrl(o['reading_background'])" width="100%" height="100" />
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','font_size')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>字体大小</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["font_size"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','font_style')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>字体样式</span>
							</view>
										<view class="diy_field diy_text">
								<span>
									{{ o["font_style"] }}
								</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','reading_progress')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>阅读进度</span>
							</view>
										<view class="diy_field diy_desc">
									<span>
										{{ obj["reading_progress"] }}
									</span>
							</view>
									</view>
					</view>
							<view class="col" v-if="0 && $check_field('get','read_comments')">
						<view class="view">
							<view class="diy_title" v-if="true">
								<span>阅读批注</span>
							</view>
										<view class="diy_field diy_desc">
									<span>
										{{ obj["read_comments"] }}
									</span>
							</view>
									</view>
					</view>
							<view class="bottom-view">
									</view>
					<view class="col">
						<view class="view">
							<view class="create_time_block diy_filed diy_time">
								{{ $toTime(o["create_time"] ,"yyyy-MM-dd hh:mm:ss") }}

							</view>
						</view>
					</view>
					<view class="uni-padding-wrap uni-common-mt">
						<navigator :url="'./details?read_settings_id=' + o['read_settings_id']" class="btn btn-primary">查看详情</navigator>

					</view>
				</view>
			</view>
		</view>
			<!-- /列表 -->
		<!-- 分页器 -->
		<uni-pagination
				class="pager"
				show-icon="true"
				:total="count"
				:pageSize="query.size"
				:current="query.page"
				@change="page_change"
		></uni-pagination>
		<!-- /分页器 -->
	</view>
</template>

<script>
	import list_tab from "@/components/diy/list_tab.vue";
	import bar_orderby from "@/components/diy/bar_orderby.vue";
    import mixin from "@/libs/mixins/page.js";


	export default {
		mixins: [mixin],
		components: {
			list_tab,
			bar_orderby
		},
		data() {
			return {
				url_get_list: "~/api/read_settings/get_list?like=0",
																	// 用户列表
					list_user_user_number: [],
										// 字体大小选项列表
				list_font_size: [{value:"全部",text:"全部"}],
							// 字体样式选项列表
				list_font_style: [{value:"全部",text:"全部"}],
						
					list_orderby: [
															{
					name: '发布时间',
					direction: "",
					command_asc: '`create_time` asc',
					command_desc: '`create_time` desc'
				}
			],
					query: {
										"book_name": "", // 图书名称
														"chapter": "", // 章节
															"read_settings_id": 0, // ID
						"page": 1,
						"size": 10
			},
			list: [],
					count: 50,
		}
		},
		methods: {



	
						
			
			
						
			
			/**
	 * 获取注册用户用户列表
	 */
	async get_list_user_user_number() {
		var json = await this.$get("~/api/user/get_list?user_group=注册用户");
		if(json.result && json.result.list){
			this.list_user_user_number = json.result.list;
		}
		else if(json.error){
			console.error(json.error);
		}
	},
	get_user_user_number(id){
		let obj = this.list_user_user_number;
		let ret = "";
		for(let i=0;i<obj.length;i++){
			if(obj[i].user_id==id){
				ret = obj[i].nickname+"-"+obj[i].username;
			}
		}
		return ret;
	},
				
			
		/**
	 * 获取字体大小列表
	 */
	async get_list_font_size() {
					['一号','二号','三号','四号','五号','六号'].map((o) => this.list_font_size.push({value:o,text:o}));
					},
			
		/**
	 * 获取字体样式列表
	 */
	async get_list_font_style() {
						var json = await this.$get("~/api/font_style/get_list?");
		if(json.result && json.result.list){
			json.result.list.map((o) => this.list_font_style.push({value:o.font_style,text:o.font_style}));
		}
		else if(json.error){
			$.toast(json.error.message);
			console.error(json.error);
		}
			},
			
			
		
	input(e, key) {
		this.query[key] = e.value;
	},

	search() {
		this.query.page = 1;
		this.get_list();
	},

	// 改变分类标签
	changeScreen(idx,key) {
		if (this.query[key] === "全部") {
			this.query[key] = "";
		}
		this.search()
	},

	// 控制排序
	handleOrderby(o) {
		// console.log(o);
		// 取出对应的orderby

		// 重置其他排序的direction
		this.list_orderby.map(val => {
			if (val.name !== o.text) {
				return val.direction = ""
			}
		})

		// 找到对应的排序项，发送排序请求
		var obj_orderby = this.list_orderby.find(val => val.name === o.text)
		if (o.direction === "") {
			this.query.orderby = ""
			this.search()
		} else if (o.direction === "up") {
			this.query.orderby = obj_orderby.command_desc
			this.search()
		} else if (o.direction === "down") {
			this.query.orderby = obj_orderby.command_asc
			this.search()
		}
	},

	/**
	 * 跳转地址
	 * @param {Object} id
	 */
	to_nav(id) {
		this.$nav('/pages/read_settings/details?read_settings_id=' + id)
	},


	},
	created() {
														this.get_list_user_user_number();
								// 初始化字体大小列表
		this.get_list_font_size();
					// 初始化字体样式列表
		this.get_list_font_style();
							}
	}
</script>
<style scoped>
.container {
  box-shadow: none;
  -webkit-box-shadow: none;
}
.pager {
  margin-top: 1rem;
}
.uni-collapse {
  background-color: inherit;
}

.pager {
  margin-top: 1rem;
}

.tab_view {
  /* background-color: #ffffff; */
  margin: 0 auto;
}

.list_orderby {
  display: flex;
  justify-content: flex-start;
  /* background-color: #ffffff; */
  /* border-top: 5px double #ccc;
		border-bottom: 5px double #ccc; */
  margin-right: -1px;
}

.list_orderby .bar_orderby {
  border-left: 1px solid #ccc;
}
.change_table {
  height: 50px;
  margin: 0 var(--margin_base);
}
.btn_change_table {
  margin-left: auto;
  font-weight: bold;
  width: 100px;
  height: 37px;
  text-align: center;
  font-size: 0.875rem;
  border: 1px solid #cccccc;
  border-radius: 1rem;
  margin: 0.25rem;
  float: right;
}
.end-title {
  display: flex;
}
.end-title view {
  flex-grow: 1;
  text-align: center;
}
.end-cont {
  display: none;
  /* background: #c8c7cc; */
}
.btna {
  color: #ffffff;
  background: #00a0ff;
}
.dis {
  display: block;
}
.box_style {
  width: 44%;
  margin-bottom: 0.75rem;
  padding: 0.375rem;
  display: inline-block !important;
  border: 0.075rem solid #ccc;
  border-radius: 0.375rem;
  overflow: hidden;
}
.box_style:nth-child(even) {
  margin-left: 0.6rem;
}
.box_style:nth-child(even) {
  margin-left: 0.6rem;
}
.bottom-view,
.create_time_block {
  font-size: 12px;
  color: #666666;
}
.bottom-view view {
  display: inline-block;
}
.bottom-view span {
  margin-left: 5px;
  margin-right: 10px;
}
</style>
<style>
/* 新加样式 */
.uni-searchbar {
  background-color: #22b8b8;
}
.search_div .uni-searchbar .uni-searchbar__box {
  border-radius: 8px !important;
  height: auto;
}

.tab_view {
  margin: 8px auto;
  font-size: 14px;
}
.list_orderby {
  margin: 1rem;
}
.list_orderby .bar_orderby {
  margin-right: 0.5rem;
  border-left: 1px solid #ccc;
  background-color: #22b8b8;
  border-radius: 10px;
  padding: 5px;
}
.sort_view .bar_orderby .text {
  color: #fff;
}
/* 列表样式 */
.dis {
  width: 50%;
  display: inline-block;
}
.end-cont .warp .container {
  font-family: Arial, Helvetica, sans-serif;
  border: 2px solid #22b8b8;
  padding: 5px;
  /* margin-top: 10px; */
  border-radius: 8px;
  margin: 10px 5px 0 5px;
  font-size: 14px;
}
.col {
  padding: 5px;
}
.end-cont .warp .container .diy_img img {
  width: 100%;
  height: 100px;
  padding: 5px 0;
}
.diy_dj {
  display: inline-block;
  width: 50%;
}
.uni-common-mt {
  width: 100%;
}
.uni-common-mt .btn {
  font-size: 14px;
  color: #fff;
  background-color: #22b8b8;
  line-height: 2;
  margin-bottom: 8px;
  display: inline-block;
	  width: 100%;
	  text-align: center;
}
.diy_text{
	padding-left: 10px;
	 color:#22b8b8;
	 text-decoration: dashed;
}
.uni-common-mt .btn{
	display: inline-block;
	  width: 100%;
	  text-align: center;
}
.container {
  padding: 8px 0s;
}
.delete_btn{
	display: inline-block;
	padding-left: 8px;
	color: #22B8B8;
	text-decoration: underline;
}
</style>
