package ir.adlas.adlasapp.thirdparty;

import lombok.SneakyThrows;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AVSMockApi implements AVSApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    List<MPolicy> policies;
    List<MHostset> hostsets;

    public AVSMockApi() {
        policies = new LinkedList<>();
        hostsets = new LinkedList<>();
    }

    public Long createHostset(String name) {
        sleep();

        MHostset h = new MHostset(name);
        hostsets.add(h);
        return (long) h.id;
    }

    public void deleteHostset(Long id) {
        sleep();

        int delcnt = 0;
        List<MHostset> hn = new LinkedList<>();
        for (MHostset mHostset : hostsets) {
            if (mHostset.id == id) {
                delcnt++;
            } else {
                hn.add(mHostset);
            }
        }
        hostsets = hn;
        if (delcnt != 1) {
            logger.error("MOCK FIRE EYE ERROR: deleting a hostset that does not exist: " + id);
        }
    }

    public String createPolicy(
            String policyName,
            List<String> excludedApplications
    ) {
        sleep();

        String exceptiondefinition = String.format("[%s]",
                excludedApplications.stream().map(s -> "\"" + StringEscapeUtils.escapeJson(s) + "\"").collect(Collectors.joining(", "))
        );

        MPolicy mp = new MPolicy(policyName, exceptiondefinition);
        policies.add(mp);
        return mp.id;
    }

    public void deletePolicy(String id) {
        sleep();

        int delcnt = 0;
        List<MPolicy> mp = new LinkedList<>();
        for (MPolicy p : policies) {
            if (p.id.equals(id)) {
                delcnt++;
            } else {
                mp.add(p);
            }
        }
        policies = mp;
        if (delcnt != 1) {
            logger.error("MOCK FIRE EYE ERROR: deleting policy which does not exist: " + id);
        }
    }

    public void joinPolicyAndHostset(String pid, Long hsid) {
        sleep();

        boolean joined = false;
        for (MPolicy p : policies) {
            if (p.id.equals(pid)) {
                p.hostsetId = hsid.intValue();
                joined = true;
            }
        }
        if (!joined) {
            logger.error("MOCK FIRE EYE ERROR: joining a policy which does not exist " + pid);
        }

        boolean hsexists = false;
        for (MHostset mHostset : hostsets) {
            if (mHostset.id == hsid) {
                hsexists = true;
            }
        }
        if (!hsexists) {
            logger.error("MOCK FIRE EYE ERROR: Joining a hostset which does not exist: " + hsid);
        }
    }

    public void addHostsToHostset(Long hsid, String hsName, List<String> hostIds) {
        sleep();

        boolean hsexists = false;
        for (MHostset mHostset : hostsets) {
            if (mHostset.id == hsid) {
                hsexists = true;
                for (String hid : hostIds) {
                    if (mHostset.hostIds.contains(hid)) {
                        logger.error("MOCK FIRE EYE ERROR: trying to add host to hostset it is already in: " + hsid + " " + hid);
                    } else {
                        mHostset.hostIds.add(hid);
                    }
                }
            }
        }
        if (!hsexists) {
            logger.error("MOCK FIRE EYE ERROR: add hosts, hostset does not exist: " + hsid);
        }
    }

    public void removeHostsFromHostset(Long hsid, List<String> hostIds) {
        sleep();

        boolean hsExists = false;
        for (MHostset mHostset : hostsets) {
            if (mHostset.id == hsid) {
                hsExists = true;
                for (String hid : hostIds) {
                    if (!mHostset.hostIds.contains(hid)) {
                        logger.error("MOCK FIRE EYE ERROR: trying to remove host from a hostset it is not in: " + hsid + " " + hid);
                    } else {
                        mHostset.hostIds.remove(hid);
                    }
                }
            }
        }
        if (!hsExists) {
            logger.error("MOCK FIRE EYE ERROR: remove hosts, hostset does not exist: " + hsid);
        }
    }

    public void print() {
        sleep();

        System.out.println("##############REPORT###################");
        for (MPolicy p : policies) {
            System.out.println("POLICY " + p.name + " {" + p.exceptiondefinition + "}, hostset=" + p.hostsetId + ", policyId=" + p.id);
        }
        System.out.println();
        for (MHostset m : hostsets) {
            System.out.println("HOSTSET " + m.name + ", hostsetId=" + m.id);
            for (String hos : m.hostIds) {
                System.out.println("\t" + hos);
            }
            System.out.println();
        }
        System.out.println("\n\n\n++++++++++++++REPORT END+++++++++++");
    }

    public static class MPolicy {
        String name;
        String id;
        String exceptiondefinition;

        long hostsetId;

        public MPolicy(String name, String exceptiondefinition) {
            this.name = name;
            this.exceptiondefinition = exceptiondefinition;
            this.id = UUID.randomUUID().toString();
        }
    }

    public static class MHostset {
        String name;
        List<String> hostIds;
        long id;

        public MHostset(String name) {
            hostIds = new LinkedList<>();
            this.name = name;
            this.id = (int) Math.round(Math.random() * 100000);
        }
    }

    @SneakyThrows
    private void sleep() {
        Thread.sleep(1000);
    }

}
