package ro.kofe.presenter

import com.soywiz.klock.DateTime


fun millisNow(): Long {
    return DateTime.nowUnixLong()
}