package org.openea.eap.module.member.convert.tag;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import org.openea.eap.module.member.controller.admin.tag.vo.MemberTagRespVO;
import org.openea.eap.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import org.openea.eap.module.member.dal.dataobject.tag.MemberTagDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员标签 Convert
 *
 */
@Mapper
public interface MemberTagConvert {

    MemberTagConvert INSTANCE = Mappers.getMapper(MemberTagConvert.class);

    MemberTagDO convert(MemberTagCreateReqVO bean);

    MemberTagDO convert(MemberTagUpdateReqVO bean);

    MemberTagRespVO convert(MemberTagDO bean);

    List<MemberTagRespVO> convertList(List<MemberTagDO> list);

    PageResult<MemberTagRespVO> convertPage(PageResult<MemberTagDO> page);

}
