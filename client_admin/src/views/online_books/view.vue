<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','book_number') || $check_field('add','book_number') || $check_field('set','book_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书编号" prop="book_number">
												<el-input id="book_number" v-model="form['book_number']" placeholder="请输入图书编号"
							  v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','book_number')) || (!form['online_books_id'] && $check_field('add','book_number'))" :disabled="disabledObj['book_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_number')">{{form['book_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_name') || $check_field('add','book_name') || $check_field('set','book_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书名称" prop="book_name">
												<el-input id="book_name" v-model="form['book_name']" placeholder="请输入图书名称"
							  v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','book_name')) || (!form['online_books_id'] && $check_field('add','book_name'))" :disabled="disabledObj['book_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_name')">{{form['book_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_category') || $check_field('add','book_category') || $check_field('set','book_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书类别" prop="book_category">
								<el-select id="book_category" v-model="form['book_category']"
						v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','book_category')) || (!form['online_books_id'] && $check_field('add','book_category'))">
						<el-option v-for="o in list_book_category" :key="o['novel_category']" :label="o['novel_category']"
							:value="o['novel_category']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','book_category')">{{form['book_category']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面" prop="cover">
								<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','cover')) || (!form['online_books_id'] && $check_field('add','cover'))">
						<img v-if="form['cover']" :src="$fullUrl(form['cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover'])" :preview-src-list="[$fullUrl(form['cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','author') || $check_field('add','author') || $check_field('set','author')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="作者" prop="author">
												<el-input id="author" v-model="form['author']" placeholder="请输入作者"
							  v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','author')) || (!form['online_books_id'] && $check_field('add','author'))" :disabled="disabledObj['author_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','author')">{{form['author']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','press') || $check_field('add','press') || $check_field('set','press')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="出版社" prop="press">
												<el-input id="press" v-model="form['press']" placeholder="请输入出版社"
							  v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','press')) || (!form['online_books_id'] && $check_field('add','press'))" :disabled="disabledObj['press_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','press')">{{form['press']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vip_price') || $check_field('add','vip_price') || $check_field('set','vip_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="VIP价格" prop="vip_price">
								<el-input-number id="vip_price" v-model.number="form['vip_price']"
						v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','vip_price')) || (!form['online_books_id'] && $check_field('add','vip_price'))" :disabled="disabledObj['vip_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','vip_price')">{{form['vip_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','book_introduction') || $check_field('add','book_introduction') || $check_field('set','book_introduction')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图书简介" prop="book_introduction">
								<el-input type="textarea" id="book_introduction" v-model="form['book_introduction']" placeholder="请输入图书简介"
						v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','book_introduction')) || (!form['online_books_id'] && $check_field('add','book_introduction'))" :disabled="disabledObj['book_introduction_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','book_introduction')">{{form['book_introduction']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','details') || $check_field('add','details') || $check_field('set','details')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="详情" prop="details">
					<quill-editor v-model.number="form['details']"
						v-if="user_group === '管理员' || (form['online_books_id'] && $check_field('set','details')) || (!form['online_books_id'] && $check_field('add','details')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','details')" v-html="form['details']"></div>
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
				field: "online_books_id",
				url_add: "~/api/online_books/add?",
				url_set: "~/api/online_books/set?",
				url_get_obj: "~/api/online_books/get_obj?",
				url_upload: "~/api/online_books/upload?",

				query: {
					"online_books_id": 0,
				},

				form: {
								"book_number":  '', // 图书编号
										"book_name":  '', // 图书名称
										"book_category":  '', // 图书类别
										"cover":  '', // 封面
										"author":  '', // 作者
										"press":  '', // 出版社
										"vip_price":  0, // VIP价格
										"book_introduction":  '', // 图书简介
										"details":  '', // 详情
											"online_books_id": 0, // ID
						
				},
				disabledObj:{
								"book_number_isDisabled": false,
										"book_name_isDisabled": false,
										"book_category_isDisabled": false,
										"cover_isDisabled": false,
										"author_isDisabled": false,
										"press_isDisabled": false,
					          			"vip_price_isDisabled": false,
										"book_introduction_isDisabled": false,
										"details_isDisabled": false,
										},

	
		
						// 图书类别选项列表
				list_book_category: [""],
	
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
				/**
			 * 获取图书类别列表
			 */
			async get_list_book_category() {
				var json = await this.$get("~/api/novel_classification/get_list?");
				if(json.result && json.result.list){
					this.list_book_category = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
						/**
			 * 上传封面
			 * @param {Object} param 图片参数
			 */
			upload_cover(param){
						this.uploadFile(param.file, "cover");
					},
	
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																	
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
					bl = this.$check_action('/online_books/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/online_books/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/online_books/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/online_books/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/online_books/view','get');
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
								this.get_list_book_category();
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
