package com.cloudian.client;

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class CloudianClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(14333);

    private CloudianClient client;

    @Before
    public void setUp() throws Exception {
        client = new CloudianClient("http://localhost:14333", "admin", "public", false);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUserAccount() throws Exception {
    }

    @Test
    public void listUserAccount() {
        final String userId = "someUser";
        final String groupId = "someGroup";
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/user?.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"userId\":\"someUser\",\"userType\":\"User\",\"fullName\":\"John Doe (jdoe)\",\"emailAddr\":\"j@doe.com\",\"address1\":null,\"address2\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null,\"phone\":null,\"groupId\":\"someGroup\",\"website\":null,\"active\":\"true\",\"canonicalUserId\":\"b3940886468689d375ebf8747b151c37\",\"ldapEnabled\":false}")));

        final CloudianUser user = client.listUser(userId, groupId);
        Assert.assertEquals(user.getActive(), true);
        Assert.assertEquals(user.getUserId(), userId);
        Assert.assertEquals(user.getGroupId(), groupId);
        Assert.assertEquals(user.getUserType(), "User");
    }

    @Test
    public void listUserAccountFail() {
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/user?.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("")));

        final CloudianUser user = client.listUser("abc", "xyz");
        Assert.assertNull(user);
    }

    @Test
    public void listUserAccounts() {
        final String groupId = "someGroup";
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/user/list?.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"userId\":\"someUser\",\"userType\":\"User\",\"fullName\":\"John Doe (jdoe)\",\"emailAddr\":\"j@doe.com\",\"address1\":null,\"address2\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null,\"phone\":null,\"groupId\":\"someGroup\",\"website\":null,\"active\":\"true\",\"canonicalUserId\":\"b3940886468689d375ebf8747b151c37\",\"ldapEnabled\":false}]")));

        final List<CloudianUser> users = client.listUsers(groupId);
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.get(0).getActive(), true);
        Assert.assertEquals(users.get(0).getGroupId(), groupId);
    }

    @Test
    public void listUserAccountsFail() {
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/user/list?.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("")));

        final List<CloudianUser> users = client.listUsers("xyz");
        Assert.assertEquals(users.size(), 0);
    }

    @Test
    public void updateUserAccount() throws Exception {
    }

    @Test
    public void removeUserAccount() throws Exception {

    }

    @Test
    public void addGroup() throws Exception {
    }

    @Test
    public void listGroup() {
        final String groupId = "someGroup";
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/group.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"groupId\":\"someGroup\",\"groupName\":\"/someDomain\",\"ldapGroup\":null,\"active\":\"true\",\"ldapEnabled\":false,\"ldapServerURL\":null,\"ldapUserDNTemplate\":null,\"ldapSearch\":null,\"ldapSearchUserBase\":null,\"ldapMatchAttribute\":null}")));

        final CloudianGroup group = client.listGroup(groupId);
        Assert.assertEquals(group.getActive(), true);
        Assert.assertEquals(group.getGroupId(), groupId);
    }

    @Test
    public void listGroupFail() {
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/group.*"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("")));

        final CloudianGroup group = client.listGroup("xyz");
        Assert.assertNull(group);
    }

    @Test
    public void listGroups() {
        final String groupId = "someGroup";
        wireMockRule.stubFor(WireMock.get(urlEqualTo("/group/list"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"groupId\":\"someGroup\",\"groupName\":\"/someDomain\",\"ldapGroup\":null,\"active\":\"true\",\"ldapEnabled\":false,\"ldapServerURL\":null,\"ldapUserDNTemplate\":null,\"ldapSearch\":null,\"ldapSearchUserBase\":null,\"ldapMatchAttribute\":null}]")));

        final List<CloudianGroup> groups = client.listGroups();
        Assert.assertEquals(groups.size(), 1);
        Assert.assertEquals(groups.get(0).getActive(), true);
        Assert.assertEquals(groups.get(0).getGroupId(), groupId);
    }

    @Test
    public void listGroupsFail() {
        wireMockRule.stubFor(WireMock.get(urlEqualTo("/group/list"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("")));

        final List<CloudianGroup> groups = client.listGroups();
        Assert.assertEquals(groups.size(), 0);
    }

    @Test
    public void updateGroup() throws Exception {
    }

    @Test
    public void removeGroup() throws Exception {
    }

}