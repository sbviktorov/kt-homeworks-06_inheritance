package ru.netology

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.objects.*
import java.util.*

class PostKtTest {
    @Before
    fun resetWallService() {
        WallService.resetWallService()
    }

    @Test
    fun wallServiceAddPostIdNonZero() {
        val unexpectedPostId = 0
        val expectedPostId = 1
        val post1 = WallService.add(Post())
        val post2 = WallService.add(Post(id = 0, text = "Пост 2"))
        val post3 = WallService.add(
            Post(
                id = 9999,
                ownerId = 888,
                fromId = 888,
                createdBy = 888,
                date = Date().time / 1000,
                text = "Пост 3",
                replyOwnerId = 1888,
                replyPostId = -1,
                friendsOnly = true,
                comments = Comments(1, true, true, true, true),
                copyright = Copyright(888, "link", "name", "type"),
                likes = Likes(12, true, true, false),
                reposts = Reposts(3, true),
                views = Views(458),
                postType = "copy",
                postSource = PostSource(type = "widget", platform = "android", data = "poll", url = "vk.com"),
                geo = Geo(type = "населенный пункт", coordinates = "координаты", Place(id = 1, title = "город",
                    latitude = 1, longitude = 0, created = (Date().time/1000)-10000, icon = "url", checkins = 1,
                    updated = Date().time/1000, type = 1, country = 7, city = 3412, address = "street, house")),
                signerId = 1888,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                donut = Donut(true, 36000, placeholder = Placeholder(), true, "all"),
                postponedId = 0
            )
        )
        assertEquals(expectedPostId, post1.id)
        assertNotEquals(unexpectedPostId, post2.id)
        assertTrue(post3.id != 0)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(Post(id = 10001, text = "Текст первого поста"))
        service.add(Post(id = 11001, text = "Текст второго поста"))
        service.add(Post(id = 11001, text = "Текст третьего поста", canPin = true))
        // создаём информацию об обновлении
        Thread.sleep(1000) //для того что бы получить разные значения date для post и updatePost
        val updatePost1 = Post(id = 1, text = "Измененный текст первого поста")
        val updatePost2 = Post(
            id = 2,
            ownerId = 888,
            fromId = 888,
            createdBy = 888,
            date = Date().time / 1000,
            text = "Измененный текст второго поста",
            replyOwnerId = 1888,
            replyPostId = -1,
            friendsOnly = true,
            comments = Comments(1, true, true, true, true),
            copyright = Copyright(888, "link", "name", "type"),
            likes = Likes(12, true, true, false),
            reposts = Reposts(1, false),
            views = Views(458),
            postType = "copy",
            signerId = 1888,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            donut = Donut(
                true, 36000, placeholder = Placeholder(),
                true, "all"
            ),
            postponedId = 0
        )
        val updatePost3 = Post(
            id = 3,
            ownerId = 777,
            text = "Измененный текст третьего поста",
            canPin = false,
            canDelete = false,
            isPinned = true
        )

        val result1 = service.update(updatePost1)
        val result2 = service.update(updatePost2)
        val result3 = service.update(updatePost3)

        assertTrue(result1)
        assertTrue(result2)
        assertTrue(result3)
    }

    @Test
    fun updateNonexisting() {
        val service = WallService
        service.add(Post(id = 10001, text = "Текст первого поста"))
        service.add(Post(id = 11001, text = "Текст второго поста"))
        service.add(Post(id = 11001, text = "Текст третьего поста", canPin = true))
        val updatePost = Post(id = 4, text = "Измененный текст второго поста")
        val result = service.update(updatePost)
        assertFalse(result)

    }

}
