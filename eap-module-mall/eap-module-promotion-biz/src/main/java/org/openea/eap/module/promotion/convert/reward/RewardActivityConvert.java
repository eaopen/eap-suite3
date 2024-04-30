package org.openea.eap.module.promotion.convert.reward;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.module.promotion.controller.admin.reward.vo.RewardActivityCreateReqVO;
import org.openea.eap.module.promotion.controller.admin.reward.vo.RewardActivityRespVO;
import org.openea.eap.module.promotion.controller.admin.reward.vo.RewardActivityUpdateReqVO;
import org.openea.eap.module.promotion.dal.dataobject.reward.RewardActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 满减送活动 Convert
 *
 */
@Mapper
public interface RewardActivityConvert {

    RewardActivityConvert INSTANCE = Mappers.getMapper(RewardActivityConvert.class);

    RewardActivityDO convert(RewardActivityCreateReqVO bean);

    RewardActivityDO convert(RewardActivityUpdateReqVO bean);

    RewardActivityRespVO convert(RewardActivityDO bean);

    PageResult<RewardActivityRespVO> convertPage(PageResult<RewardActivityDO> page);

}
