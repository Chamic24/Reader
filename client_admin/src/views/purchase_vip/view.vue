<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','book_number') || $check_field('add','book_number') || $check_field('set','book_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书编号" prop="book_number">
												<el-input id="book_number" v-model="form['book_number']" placeholder="请输入图书编号"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','book_number')) || (!form['purchase_vip_id'] && $check_field('add','book_number'))" :disabled="disabledObj['book_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_number')">{{form['book_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_name') || $check_field('add','book_name') || $check_field('set','book_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书名称" prop="book_name">
												<el-input id="book_name" v-model="form['book_name']" placeholder="请输入图书名称"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','book_name')) || (!form['purchase_vip_id'] && $check_field('add','book_name'))" :disabled="disabledObj['book_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_name')">{{form['book_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_category') || $check_field('add','book_category') || $check_field('set','book_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书类别" prop="book_category">
												<el-input id="book_category" v-model="form['book_category']" placeholder="请输入图书类别"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','book_category')) || (!form['purchase_vip_id'] && $check_field('add','book_category'))" :disabled="disabledObj['book_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_category')">{{form['book_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','author') || $check_field('add','author') || $check_field('set','author')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="作者" prop="author">
												<el-input id="author" v-model="form['author']" placeholder="请输入作者"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','author')) || (!form['purchase_vip_id'] && $check_field('add','author'))" :disabled="disabledObj['author_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','author')">{{form['author']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vip_price') || $check_field('add','vip_price') || $check_field('set','vip_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="VIP价格" prop="vip_price">
												<el-input id="vip_price" v-model="form['vip_price']" placeholder="请输入VIP价格"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','vip_price')) || (!form['purchase_vip_id'] && $check_field('add','vip_price'))" :disabled="disabledObj['vip_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vip_price')">{{form['vip_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_number(form['user_number']) }}
							<!--<el-input id="business_name" v-model="form['user_number']" placeholder="请输入用户编号"-->
							<!--v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','user_number')) || (!form['purchase_vip_id'] && $check_field('add','user_number'))" :disabled="disabledObj['user_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_number')">{{form['user_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','user_number')) || (!form['purchase_vip_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_number')" id="user_number" v-model="form['user_number']" :disabled="true">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','full_name')) || (!form['purchase_vip_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','telephone') || $check_field('add','telephone') || $check_field('set','telephone')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="电话" prop="telephone">
												<el-input id="telephone" v-model="form['telephone']" placeholder="请输入电话"
							  v-if="user_group === '管理员' || (form['purchase_vip_id'] && $check_field('set','telephone')) || (!form['purchase_vip_id'] && $check_field('add','telephone'))" :disabled="disabledObj['telephone_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','telephone')">{{form['telephone']}}</div>
											</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
	
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "purchase_vip_id",
				url_add: "~/api/purchase_vip/add?",
				url_set: "~/api/purchase_vip/set?",
				url_get_obj: "~/api/purchase_vip/get_obj?",
				url_upload: "~/api/purchase_vip/upload?",

				query: {
					"purchase_vip_id": 0,
				},

				form: {
								"book_number":  '', // 图书编号
										"book_name":  '', // 图书名称
										"book_category":  '', // 图书类别
										"author":  '', // 作者
										"vip_price":  '', // VIP价格
										"user_number": 0, // 用户编号
										"full_name":  '', // 姓名
										"telephone":  '', // 电话
									"examine_state": "未审核",
							"examine_reply": "",
							"purchase_vip_id": 0, // ID
						
				},
				disabledObj:{
								"book_number_isDisabled": false,
										"book_name_isDisabled": false,
										"book_category_isDisabled": false,
										"author_isDisabled": false,
										"vip_price_isDisabled": false,
										"user_number_isDisabled": false,
										"full_name_isDisabled": false,
										"telephone_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_user_number: [],
						// 用户组
				group_user_user_number: "",
				
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_number() {
                // if(this.user_group !== "管理员" && this.form["user_number"] === 0) {
                //     this.form["user_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=注册用户");
                if(json.result && json.result.list){
                    this.list_user_user_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取注册用户用户组
			 */
			async get_group_user_user_number() {
							this.form["user_number"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
				if(json.result && json.result.obj){
					this.group_user_user_number = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_number(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_number.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["user_number"] = id
									_this.disabledObj['user_number' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "user_number") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_user_number(id){
				var obj = this.list_user_user_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
												// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
														
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																								


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																														return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/purchase_vip/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/purchase_vip/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/purchase_vip/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/purchase_vip/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/purchase_vip/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
															this.get_list_user_user_number();
					this.get_group_user_user_number();
									},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
