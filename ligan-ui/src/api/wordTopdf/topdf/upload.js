import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listUpload(query) {
  return request({
    url: '/system/upload/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getUpload(id) {
  return request({
    url: '/system/upload/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addUpload(data) {
  return request({
    url: '/system/upload',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateUpload(data) {
  return request({
    url: '/system/upload',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delUpload(id) {
  return request({
    url: '/system/upload/' + id,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportUpload(query) {
  return request({
    url: '/system/upload/export',
    method: 'get',
    params: query
  })
}