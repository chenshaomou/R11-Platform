package org.rainboweleven.platform.domain.pm;

import org.eclipse.jgit.api.Git;

import java.io.File;

//git 地址映射对象
public class GitRepository {

    private String repositoryURL;
    private String branch;
    private String username;
    private String password;

    public GitRepository(String repositoryURL, String branch, String username, String password) {
        this.repositoryURL = repositoryURL;
        this.branch = branch;
        this.username = username;
        this.password = password;
    }

    public GitRepository(){}

    public String getRepositoryURL() {
        return repositoryURL;
    }

    public void setRepositoryURL(String repositoryURL) {
        this.repositoryURL = repositoryURL;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void cloneRemote(){
        Git.cloneRepository()
                .setURI(this.repositoryURL)
                .setBranch(this.branch)
                .setDirectory(new File("/Users/chenshaomou/Desktop/pmgit"));
    }
}
