package beans;


import services.CreateWiki;
import utils.GeneralUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by sourabh.su on 22/01/17.
 */
public class WikiBean {
    private String title;
    private String content;
    private String userId;
    private String userName;
    private String teamName;
    private String visibleTo;
    private String keyword;
    private String documentId;
    private String description;


    public WikiBean(HttpServletRequest request) {
        this.title = getString(request, "title");
        this.content = getString(request, "content");
        this.userId = getString(request, "userId");
        this.userName = getString(request, "userName");
        this.visibleTo = getString(request, "visibleTo");
        this.keyword = getString(request, "keyword");
        this.documentId = getString(request, "documentId");
        this.teamName = CreateWiki.getInstance().getUserDetailsFromSql(this.userId).get("teamId").toString();
        this.description = GeneralUtils.getDescriptionFromContent(this.content);
        System.out.println("Recieved crate wiki request for user " + this.userId);
    }

    private String getString(HttpServletRequest request, String pid) {
        return request.getParameter(pid);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getVisibleTo() {
        return visibleTo;
    }

    public String getUserName() {
        return userName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
