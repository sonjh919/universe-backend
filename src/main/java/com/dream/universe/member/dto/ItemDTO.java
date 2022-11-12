package com.dream.universe.member.dto;

public class ItemDTO {
    private Long memberCode;
    private Long itemHairCode;
    private Long itemFaceCode;
    private Long itemClothCode;

    public ItemDTO(){};

    public ItemDTO(Long memberCode, Long itemHairCode, Long itemFaceCode, Long itemClothCode) {
        this.memberCode = memberCode;
        this.itemHairCode = itemHairCode;
        this.itemFaceCode = itemFaceCode;
        this.itemClothCode = itemClothCode;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public Long getItemHairCode() {
        return itemHairCode;
    }

    public void setItemHairCode(Long itemHairCode) {
        this.itemHairCode = itemHairCode;
    }

    public Long getItemFaceCode() {
        return itemFaceCode;
    }

    public void setItemFaceCode(Long itemFaceCode) {
        this.itemFaceCode = itemFaceCode;
    }

    public Long getItemClothCode() {
        return itemClothCode;
    }

    public void setItemClothCode(Long itemClothCode) {
        this.itemClothCode = itemClothCode;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "memberCode=" + memberCode +
                ", itemHairCode=" + itemHairCode +
                ", itemFaceCode=" + itemFaceCode +
                ", itemClothCode=" + itemClothCode +
                '}';
    }
}
