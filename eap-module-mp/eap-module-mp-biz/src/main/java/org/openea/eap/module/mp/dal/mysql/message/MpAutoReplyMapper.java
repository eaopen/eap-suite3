package org.openea.eap.module.mp.dal.mysql.message;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.framework.mybatis.core.mapper.BaseMapperX;
import org.openea.eap.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.openea.eap.module.mp.controller.admin.message.vo.message.MpMessagePageReqVO;
import org.openea.eap.module.mp.dal.dataobject.message.MpAutoReplyDO;
import org.openea.eap.module.mp.enums.message.MpAutoReplyMatchEnum;
import org.openea.eap.module.mp.enums.message.MpAutoReplyTypeEnum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpAutoReplyMapper extends BaseMapperX<MpAutoReplyDO> {

    default PageResult<MpAutoReplyDO> selectPage(MpMessagePageReqVO pageVO) {
        return selectPage(pageVO, new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAccountId, pageVO.getAccountId())
                .eqIfPresent(MpAutoReplyDO::getType, pageVO.getType()));
    }

    default List<MpAutoReplyDO> selectListByAppIdAndKeywordAll(String appId, String requestKeyword) {
        return selectList(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAppId, appId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.KEYWORD.getType())
                .eq(MpAutoReplyDO::getRequestMatch, MpAutoReplyMatchEnum.ALL.getMatch())
                .eq(MpAutoReplyDO::getRequestKeyword, requestKeyword));
    }

    default List<MpAutoReplyDO> selectListByAppIdAndKeywordLike(String appId, String requestKeyword) {
        return selectList(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAppId, appId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.KEYWORD.getType())
                .eq(MpAutoReplyDO::getRequestMatch, MpAutoReplyMatchEnum.LIKE.getMatch())
                .like(MpAutoReplyDO::getRequestKeyword, requestKeyword));
    }

    default List<MpAutoReplyDO> selectListByAppIdAndMessage(String appId, String requestMessageType) {
        return selectList(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAppId, appId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.MESSAGE.getType())
                .eq(MpAutoReplyDO::getRequestMessageType, requestMessageType));
    }

    default List<MpAutoReplyDO> selectListByAppIdAndSubscribe(String appId) {
        return selectList(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAppId, appId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.SUBSCRIBE.getType()));
    }

    default MpAutoReplyDO selectByAccountIdAndSubscribe(Long accountId) {
        return selectOne(MpAutoReplyDO::getAccountId, accountId,
                MpAutoReplyDO::getType, MpAutoReplyTypeEnum.SUBSCRIBE.getType());
    }

    default MpAutoReplyDO selectByAccountIdAndMessage(Long accountId, String requestMessageType) {
        return selectOne(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAccountId, accountId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.MESSAGE.getType())
                .eq(MpAutoReplyDO::getRequestMessageType, requestMessageType));
    }

    default MpAutoReplyDO selectByAccountIdAndKeyword(Long accountId, String requestKeyword) {
        return selectOne(new LambdaQueryWrapperX<MpAutoReplyDO>()
                .eq(MpAutoReplyDO::getAccountId, accountId)
                .eq(MpAutoReplyDO::getType, MpAutoReplyTypeEnum.KEYWORD.getType())
                .eq(MpAutoReplyDO::getRequestKeyword, requestKeyword));
    }
}
