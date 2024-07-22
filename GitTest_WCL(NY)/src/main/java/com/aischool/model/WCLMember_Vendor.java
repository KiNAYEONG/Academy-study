package com.aischool.model;

public class WCLMember_Vendor {
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String email;
    private String address;
    private String license;
    private String category;
    private String license_image;
    private String logo_image;
    private String intro;
    private String site_url;
    private String join;
    
    // 새로 추가할 필드
    private String postcode;
    private String detailAddress;
    private String extraAddress;

    public WCLMember_Vendor() {
        
    }

    public WCLMember_Vendor(String id, String pw, String name, String category) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.category = category;
    }

    public WCLMember_Vendor(String id, String pw, String name, String tel, String email, String address, String license,
            String category, String license_image, String logo_image, String intro, String site_url) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.license = license;
        this.category = category;
        this.license_image = license_image;
        this.logo_image = logo_image;
        this.intro = intro;
        this.site_url = site_url;
    }

    // 추가된 필드 포함 생성자
    public WCLMember_Vendor(String id, String pw, String name, String tel, String email, String address, String detailAddress, String extraAddress, String postcode, String license, String category, String license_image, String logo_image, String intro, String site_url) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
        this.postcode = postcode;
        this.license = license;
        this.category = category;
        this.license_image = license_image;
        this.logo_image = logo_image;
        this.intro = intro;
        this.site_url = site_url;
    }

    // getter 및 setter 메소드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLicense_image() {
        return license_image;
    }

    public void setLicense_image(String license_image) {
        this.license_image = license_image;
    }

    public String getLogo_image() {
        return logo_image;
    }

    public void setLogo_image(String logo_image) {
        this.logo_image = logo_image;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    // 추가된 필드 getter 및 setter
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getExtraAddress() {
        return extraAddress;
    }

    public void setExtraAddress(String extraAddress) {
        this.extraAddress = extraAddress;
    }
}
