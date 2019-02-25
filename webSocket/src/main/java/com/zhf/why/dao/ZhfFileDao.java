package com.zhf.why.dao;




import com.zhf.why.model.ZhfFileNode;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface ZhfFileDao {

    @Select("SELECT id,name,path,parId,type FROM GWN_FILEMANAGE_FILE ")
    List<ZhfFileNode> getFileInfo();


}
