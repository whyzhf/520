package com.zhf.why.serviceImpl;


import com.alibaba.fastjson.JSON;
import com.zhf.why.dao.ZhfFileDao;
import com.zhf.why.model.ZhfFileNode;
import com.zhf.why.service.ZhfFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ZhfFileServiceImpl implements ZhfFileService {

    @Resource
    private ZhfFileDao zhfFileDao;

    /**
     * 得到目录文件和名字
     *Data
     * @return
     */
    @Override
    public String getFileInfo() {
        //获取所有的数据
        List<ZhfFileNode> fileInfo = zhfFileDao.getFileInfo();
        //获取根节点
        ZhfFileNode zhfFileNode = setRoot();
        //递归生成树结构
        ZhfFileNode recursive = recursive(zhfFileNode, fileInfo);
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("data", recursive);
        String json = JSON.toJSONString(resMap, true);

        return json;
    }



    //递归生成树的结构
    public ZhfFileNode recursive(ZhfFileNode root,List<ZhfFileNode> deposityData){
        for (int i = 0; i <deposityData.size() ; i++) {
            if(deposityData.get(i).getParId()==root.getId()){
                root.addChildren(deposityData.get(i));
                recursive(deposityData.get(i),deposityData);
            }
        }
        return root;
    }

    //设置根节点
    public static ZhfFileNode  setRoot(){
        ZhfFileNode zhfFileNode = new ZhfFileNode();
           zhfFileNode.setId(1);
           zhfFileNode.setName("data");
       return zhfFileNode;
    }

}
