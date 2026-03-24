package za.ac.cput.domain;

public class User {
    public String userId;
    public String userName;
    public String email;

    private  User() {
    }

    public User (Builder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.email = builder.email;
    }



    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder {
        private String userId;
        private String userName;
        private String email;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder copy(User user){
            this.userId  = user.userId;
            this.userName = user.userName;
            this.email = user.email;
            return this;
        }
        public User build(){
            return  new User(this);
        }
    }
}
