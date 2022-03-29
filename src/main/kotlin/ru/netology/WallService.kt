package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Int = 1
    fun add(post: Post): Post {

        val newPost = post.copy(id = postId++)
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postInPosts) in posts.withIndex()) {
            if (post.id == postInPosts.id) {
                posts[index] = post.copy(
                    ownerId = posts[index].ownerId,
                    date = posts[index].date
                )
                return true
            }
        }
        return false
    }

    fun resetWallService() {
        posts = emptyArray<Post>()
        postId = 1


    }
}