package com.labawsrh.aws.introscreen;

public class Education {
    private String imgName;
    private String imgUrl;
    private String seconddesc;
    private String contact;
    private String Address;



    public Education() {
    }





    public Education(String imgName, String imgUrl, String seconddesc, String contact, String Address) {
        if(imgName.trim().equals(""))
        {
            imgName="No name";
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.seconddesc=seconddesc;
        this.contact=contact;
        this.Address=Address;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getSeconddesc() {
        return seconddesc;
    }
    public String getContact() {
        return contact;
    }
    public String getAddress() {
        return Address;
    }


    public void setSeconddesc(String seconddesc) {
        this.seconddesc = seconddesc;
    }
   public void setContact(String contact) {
        this.contact = contact;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }




    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
