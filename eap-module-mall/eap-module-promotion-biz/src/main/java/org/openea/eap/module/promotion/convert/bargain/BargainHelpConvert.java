package org.openea.eap.module.promotion.convert.bargain;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.framework.common.util.collection.MapUtils;
import org.openea.eap.module.member.api.user.dto.MemberUserRespDTO;
import org.openea.eap.module.promotion.controller.admin.bargain.vo.help.BargainHelpRespVO;
import org.openea.eap.module.promotion.controller.app.bargain.vo.help.AppBargainHelpRespVO;
import org.openea.eap.module.promotion.dal.dataobject.bargain.BargainHelpDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

/**
 * 砍价助力 Convert
 *
 */
@Mapper
public interface BargainHelpConvert {

    BargainHelpConvert INSTANCE = Mappers.getMapper(BargainHelpConvert.class);

    default PageResult<BargainHelpRespVO> convertPage(PageResult<BargainHelpDO> page,
                                                      Map<Long, MemberUserRespDTO> userMap) {
        PageResult<BargainHelpRespVO> pageResult = convertPage(page);
        // 拼接数据
        pageResult.getList().forEach(record ->
                MapUtils.findAndThen(userMap, record.getUserId(),
                        user -> record.setNickname(user.getNickname()).setAvatar(user.getAvatar())));
        return pageResult;
    }
    PageResult<BargainHelpRespVO> convertPage(PageResult<BargainHelpDO> page);

    default List<AppBargainHelpRespVO> convertList(List<BargainHelpDO> helps,
                                                   Map<Long, MemberUserRespDTO> userMap) {
        List<AppBargainHelpRespVO> helpVOs = convertList02(helps);
        helpVOs.forEach(help ->
                MapUtils.findAndThen(userMap, help.getUserId(),
                        user -> help.setNickname(user.getNickname()).setAvatar(user.getAvatar())));
        return helpVOs;
    }
    List<AppBargainHelpRespVO> convertList02(List<BargainHelpDO> helps);

}
