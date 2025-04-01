<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','book_number') || $check_field('add','book_number') || $check_field('set','book_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书编号" prop="book_number">
												<el-input id="book_number" v-model="form['book_number']" placeholder="请输入图书编号"
							  v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','book_number')) || (!form['read_settings_id'] && $check_field('add','book_number'))" :disabled="disabledObj['book_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_number')">{{form['book_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_name') || $check_field('add','book_name') || $check_field('set','book_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书名称" prop="book_name">
												<el-input id="book_name" v-model="form['book_name']" placeholder="请输入图书名称"
							  v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','book_name')) || (!form['read_settings_id'] && $check_field('add','book_name'))" :disabled="disabledObj['book_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_name')">{{form['book_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_category') || $check_field('add','book_category') || $check_field('set','book_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书类别" prop="book_category">
												<el-input id="book_category" v-model="form['book_category']" placeholder="请输入图书类别"
							  v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','book_category')) || (!form['read_settings_id'] && $check_field('add','book_category'))" :disabled="disabledObj['book_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_category')">{{form['book_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','author') || $check_field('add','author') || $check_field('set','author')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="作者" prop="author">
												<el-input id="author" v-model="form['author']" placeholder="请输入作者"
							  v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','author')) || (!form['read_settings_id'] && $check_field('add','author'))" :disabled="disabledObj['author_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','author')">{{form['author']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','chapter') || $check_field('add','chapter') || $check_field('set','chapter')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="章节" prop="chapter">
												<el-input id="chapter" v-model="form['chapter']" placeholder="请输入章节"
							  v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','chapter')) || (!form['read_settings_id'] && $check_field('add','chapter'))" :disabled="disabledObj['chapter_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','chapter')">{{form['chapter']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_number(form['user_number']) }}
							<!--<el-input id="business_name" v-model="form['user_number']" placeholder="请输入用户编号"-->
							<!--v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','user_number')) || (!form['read_settings_id'] && $check_field('add','user_number'))" :disabled="disabledObj['user_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_number')">{{form['user_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','user_number')) || (!form['read_settings_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','reading_background') || $check_field('add','reading_background') || $check_field('set','reading_background')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="阅读背景" prop="reading_background">
								<el-upload :disabled="disabledObj['reading_background_isDisabled']" id="reading_background" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_reading_background"
						:show-file-list="false" v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','reading_background')) || (!form['read_settings_id'] && $check_field('add','reading_background'))">
						<img v-if="form['reading_background']" :src="$fullUrl(form['reading_background'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','reading_background')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['reading_background'])" :preview-src-list="[$fullUrl(form['reading_background'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','font_size') || $check_field('add','font_size') || $check_field('set','font_size')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="字体大小" prop="font_size">
								<el-select id="font_size" v-model="form['font_size']"
						v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','font_size')) || (!form['read_settings_id'] && $check_field('add','font_size'))">
						<el-option v-for="o in list_font_size" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','font_size')">{{form['font_size']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','font_style') || $check_field('add','font_style') || $check_field('set','font_style')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="字体样式" prop="font_style">
								<el-select id="font_style" v-model="form['font_style']"
						v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','font_style')) || (!form['read_settings_id'] && $check_field('add','font_style'))">
						<el-option v-for="o in list_font_style" :key="o['font_style']" :label="o['font_style']"
							:value="o['font_style']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','font_style')">{{form['font_style']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reading_progress') || $check_field('add','reading_progress') || $check_field('set','reading_progress')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="阅读进度" prop="reading_progress">
								<el-input type="textarea" id="reading_progress" v-model="form['reading_progress']" placeholder="请输入阅读进度"
						v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','reading_progress')) || (!form['read_settings_id'] && $check_field('add','reading_progress'))" :disabled="disabledObj['reading_progress_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reading_progress')">{{form['reading_progress']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','read_comments') || $check_field('add','read_comments') || $check_field('set','read_comments')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="阅读批注" prop="read_comments">
								<el-input type="textarea" id="read_comments" v-model="form['read_comments']" placeholder="请输入阅读批注"
						v-if="user_group === '管理员' || (form['read_settings_id'] && $check_field('set','read_comments')) || (!form['read_settings_id'] && $check_field('add','read_comments'))" :disabled="disabledObj['read_comments_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','read_comments')">{{form['read_comments']}}</div>
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
				field: "read_settings_id",
				url_add: "~/api/read_settings/add?",
				url_set: "~/api/read_settings/set?",
				url_get_obj: "~/api/read_settings/get_obj?",
				url_upload: "~/api/read_settings/upload?",

				query: {
					"read_settings_id": 0,
				},

				form: {
								"book_number":  '', // 图书编号
										"book_name":  '', // 图书名称
										"book_category":  '', // 图书类别
										"author":  '', // 作者
										"chapter":  '', // 章节
										"user_number": 0, // 用户编号
										"reading_background":  '', // 阅读背景
										"font_size":  '', // 字体大小
										"font_style":  '', // 字体样式
										"reading_progress":  '', // 阅读进度
										"read_comments":  '', // 阅读批注
											"read_settings_id": 0, // ID
						
				},
				disabledObj:{
								"book_number_isDisabled": false,
										"book_name_isDisabled": false,
										"book_category_isDisabled": false,
										"author_isDisabled": false,
										"chapter_isDisabled": false,
										"user_number_isDisabled": false,
										"reading_background_isDisabled": false,
										"font_size_isDisabled": false,
										"font_style_isDisabled": false,
										"reading_progress_isDisabled": false,
										"read_comments_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_user_number: [],
						// 用户组
				group_user_user_number: "",
				
						// 字体大小选项列表
				list_font_size: ['一号','二号','三号','四号','五号','六号'],
	
						// 字体样式选项列表
				list_font_style: [""],
	
		
		
	
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
			 * 上传阅读背景
			 * @param {Object} param 图片参数
			 */
			upload_reading_background(param){
						this.uploadFile(param.file, "reading_background");
					},
	
	
			
	
			
				/**
			 * 获取字体样式列表
			 */
			async get_list_font_style() {
				var json = await this.$get("~/api/font_style/get_list?");
				if(json.result && json.result.list){
					this.list_font_style = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
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
					bl = this.$check_action('/read_settings/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/read_settings/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/read_settings/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/read_settings/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/read_settings/view','get');
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
											this.get_list_font_style();
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
